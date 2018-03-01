package activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.ImageSliderAdaper;

public class ImageSliderView extends AppCompatActivity {

    private InfiniteCardView infiniteCardView;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iamage_slider_view);

        infiniteCardView = findViewById(R.id.imageSliderView);
        relativeLayout = findViewById(R.id.infiniteCardLayout);
        infiniteCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        infiniteCardView.setAnimInterpolator(new LinearInterpolator());
        infiniteCardView.setTransformerToFront(new DefaultTransformerToFront());
        infiniteCardView.setTransformerToBack(new DefaultTransformerToBack());
        final List<Integer> images = new ArrayList<>();
        images.add(R.drawable.tick_image);

        images.add(R.drawable.social_media);
        infiniteCardView.setAdapter(new ImageSliderAdaper(this, images, infiniteCardView));
        infiniteCardView.setClickable(true);

    }
}
