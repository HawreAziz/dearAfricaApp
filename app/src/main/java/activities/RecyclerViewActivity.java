package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerViewAdapter;
import custom.classes.Topic;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<Topic> topics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.whatsUpRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for(int i=0; i < 20; i++){
            topics.add(new Topic("Title"+i, "Description", "23:30", R.drawable.tick_image));
        }
        recyclerView.setAdapter(new RecyclerViewAdapter(this, topics));
    }
}
