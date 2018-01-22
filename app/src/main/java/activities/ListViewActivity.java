package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.whatsup.hawre.whatsup.R;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /*List<Topic> entries = new ArrayList<>();
        for(int i=0; i< 20; i++)
            entries.add(new Topic(getIntent().getStringExtra("topic") + " " + i, "description " +i, "01:30", R.drawable.tick_image));

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.activity_list_view_row,entries);
        listView = findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);

        // listener for item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topic = (Topic)adapterView.getAdapter().getItem(i);

                Toast.makeText(ListViewActivity.this, topic.getTitle(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListViewActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });*/


    }
}
