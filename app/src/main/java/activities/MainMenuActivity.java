package activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.lukedeighton.wheelview.WheelView;
import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.ListViewAdapter;
import adapters.WheelViewAdapter;
import custom.classes.Topic;

public class MainMenuActivity extends AppCompatActivity {

    private WheelView wheelView;
    private ListView listView;
    private ViewStub wheelStub;
    private ViewStub listStub;
    private int currentViewMode;
    private final int VIEW_MODE_LISTMODE = 0;
    private final int VIEW_MODE_WHEELMODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        wheelStub = findViewById(R.id.MainMenuwheelStub);
        listStub = findViewById(R.id.MainMenulistStub);


        wheelStub.inflate();
        listStub.inflate();
        listView = findViewById(R.id.listView);
        wheelView = findViewById(R.id.wheelview);


        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();


        wheelView.setWheelRadius(height/2);
        wheelView.setWheelItemAngle(30.0f);

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTMODE);


        changeView ();
        setAdapters();

        /*listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainMenuActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });*/

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                WheelViewAdapter buttonAdapter = (WheelViewAdapter) parent.getAdapter();
                String msg = buttonAdapter.getItem(position) + " was selected";
                //Toast.makeText(WheelMenuActivity.this, msg, Toast.LENGTH_LONG).show();
                Intent welcome = new Intent(MainMenuActivity.this, GridViewActivity.class);
                welcome.putExtra("topic", buttonAdapter.getItem(position));
                startActivity(welcome);
            }
        });

    }



    private void setAdapters() {
        List<Topic> entries = new ArrayList<>();
        for(int i=0; i< 20; i++)
            entries.add(new Topic("topic" + " " + i, "description " +i, "01:30", R.drawable.tick_image));
        if(currentViewMode == VIEW_MODE_LISTMODE){
            ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.activity_list_view_row, entries);
            listView.setAdapter(listViewAdapter);
        }else{
            List<String> list = new ArrayList<>();
            for(int i=0; i<20; i++)
                list.add("title" + i);
            WheelViewAdapter wheelViewAdapter = new WheelViewAdapter(list);
            wheelView.setAdapter(wheelViewAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_wheel_list:
                if(currentViewMode == VIEW_MODE_LISTMODE){
                    currentViewMode = VIEW_MODE_WHEELMODE;
                }else{
                    currentViewMode = VIEW_MODE_LISTMODE;
                }
                changeView();
                setAdapters();
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.wheel_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void changeView(){
        if(currentViewMode == VIEW_MODE_LISTMODE){
            listStub.setVisibility(View.VISIBLE);
            wheelStub.setVisibility(View.GONE);
        }else{
            listStub.setVisibility(View.GONE);
            wheelStub.setVisibility(View.VISIBLE);
        }
    }

}
