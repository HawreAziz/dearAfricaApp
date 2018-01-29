package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.whatsup.hawre.whatsup.R;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

import adapters.InfinitViewAdapter;
import custom.classes.Topic;

public class InfinitViewActivity extends AppCompatActivity {

    List<Topic> images = new ArrayList<>();
    HorizontalInfiniteCycleViewPager horizontalCycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinit_view);
        horizontalCycleViewPager = findViewById(R.id.whatsAppInfinitView);
        for (int i = 0; i < 10; i++) {
            images.add(new Topic("Title #" + (i+1), "description #"+(i+1), "21:27", R.drawable.tick_image));

        }

        Assert.assertFalse(images.isEmpty());
        InfinitViewAdapter infinitViewAdapter = new InfinitViewAdapter(this, images);
        horizontalCycleViewPager.setAdapter(infinitViewAdapter);

    }
}
