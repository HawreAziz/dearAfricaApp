package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.GridViewAdapter;
import custom.classes.Topic;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        //for test purpose should be removed later and fetch data from the real database
        List<Topic> entries = new ArrayList<>();
        for(int i=0; i<20; i++){
            entries.add(new Topic("Title", "Description", "02:30", R.drawable.tick_image));
        }

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(this, R.layout.activity_grid_view_item, entries));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topic = (Topic) adapterView.getAdapter().getItem(i);
                //Toast.makeText(GridViewActivity.this, topic.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GridViewActivity.this, TopicActivity.class);
                startActivity(intent);

            }
        });

    }
}