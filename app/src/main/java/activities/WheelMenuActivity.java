package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.WheelViewAdapter;

public class WheelMenuActivity extends AppCompatActivity {

    private WheelView wheelView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_grid_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wheel_menu);
        wheelView = findViewById(R.id.wheelview);
        List<String> list = new ArrayList<>();
        list.add("Politics");
        list.add("Society");
        list.add("Schoolarship");
        list.add("Friendship");
        list.add("Sex");
        list.add("Apperance");
        list.add("Model");
        list.add("Make-up");
        list.add("Technology");
        list.add("Movies");
        list.add("Religion");
        list.add("Sport");
        list.add("Environment");
        list.add("Books");

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        System.out.println("size of the screen: " + height);

        wheelView.setAdapter(new WheelViewAdapter(list));
        wheelView.setWheelRadius(height/2);
        wheelView.setWheelItemAngle(30.0f);

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {

                WheelViewAdapter buttonAdapter = (WheelViewAdapter) parent.getAdapter();

                String msg = buttonAdapter.getItem(position) + " was selected";
                Toast.makeText(WheelMenuActivity.this, msg, Toast.LENGTH_LONG).show();
                Intent welcome = new Intent(WheelMenuActivity.this, HorizontalRecyclerView.class);
                //welcome.putExtra("topic", buttonAdapter.getItem(position));
                startActivity(welcome);
            }
        });





    }
}
