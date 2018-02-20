package activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.whatsup.hawre.whatsup.R;
import java.util.ArrayList;
import java.util.List;
import adapters.HorizontalRecyclerViewAdapter;
import custom.classes.Topic;


public class HorizontalSectionList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Topic> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        recyclerView = findViewById(R.id.horizontalRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        entries = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            entries.add(new Topic("Horizontal Topic"+i,
                    "Horizontal Description", "14:53",R.drawable.tick_image));
        }
        recyclerView.setAdapter(new HorizontalRecyclerViewAdapter(this, entries));
    }
}
