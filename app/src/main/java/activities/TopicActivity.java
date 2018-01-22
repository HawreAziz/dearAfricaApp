package activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.whatsup.hawre.whatsup.R;

import adapters.SliderViewAdapter;

public class TopicActivity extends AppCompatActivity {

    private ViewPager viewPager;

    //for test purpose only, should be removed later when the real database is up
    private Integer[] images = {R.drawable.java, R.drawable.social_media, R.drawable.tick_image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        viewPager = findViewById(R.id.whatsUpSlider);

        viewPager.setAdapter(new SliderViewAdapter(this, images));
    }
}
