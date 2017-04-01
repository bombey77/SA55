package bombey77.sa55;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "myLog";

    ArrayAdapter<String> arrayAdapter;
    String [] data = {"1","2","3","4","5","6","7"};
    ListView listView;

    View header1;
    View header2;
    View footer1;
    View footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.lv_main);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        header1 = createHeader("Header 1", "Add new Day");
        header2 = createHeader("Header 2", "Second Row");

        footer1 = createFooter("Footer 1");
        footer2 = createFooter("Footer 2");

        fillList();
    }

    private void fillList() {
        listView.addHeaderView(header1);
        listView.addHeaderView(header2, "some text for header 2", false);
        listView.addFooterView(footer1);
        listView.addFooterView(footer2, "some text for footer 2", false);
        listView.setAdapter(arrayAdapter);
    }

    public void onClick(View v) {
        //Получение данных

        //учитывает Header and Footer
        Object object;
        HeaderViewListAdapter hvlAdapter = (HeaderViewListAdapter)listView.getAdapter();
        object = hvlAdapter.getItem(1);
        Log.d("myLog", object.toString());
        object = hvlAdapter.getItem(3);
        Log.d("myLog", object.toString());

        //не учитывает Header and Footer
        ArrayAdapter<String> arrayAdapter = (ArrayAdapter<String>)hvlAdapter.getWrappedAdapter();
        object = arrayAdapter.getItem(1);
        Log.d("myLog", object.toString());
        object = arrayAdapter.getItem(3);
        Log.d("myLog", object.toString());
    }

    View createHeader(String text, String textLand) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.tvHeader)).setText(text);
        ((TextView) v.findViewById(R.id.tvTitle)).setText(textLand);
        return v;
    }

    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) v.findViewById(R.id.tvFooter)).setText(text);
        return v;
    }
}
