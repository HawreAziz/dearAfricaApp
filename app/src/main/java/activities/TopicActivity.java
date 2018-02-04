package activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;

import adapters.SliderViewAdapter;

public class TopicActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton likeBtn;
    private ImageButton unLikeBtn;
    private ImageButton commentBtn;
    private TextView commentTextWidget;
    private ImageButton shareBtn;
    private EditText shareTextWdiget;
    private EditText likeRateView;
    private EditText unLikeRateView;

    //for test purpose only, should be removed later when the real database is up
    private Integer[] images = {R.drawable.java, R.drawable.social_media, R.drawable.tick_image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        viewPager = findViewById(R.id.whatsUpSlider);
        likeBtn = findViewById(R.id.likeButton);
        unLikeBtn = findViewById(R.id.unLikeButton);
        commentBtn = findViewById(R.id.commentIcon);
        commentTextWidget = findViewById(R.id.commentText);
        shareBtn = findViewById(R.id.shareIcon);
        shareTextWdiget = findViewById(R.id.shareText);
        likeRateView = findViewById(R.id.likeRate);
        unLikeRateView = findViewById(R.id.unLikeRate);

        viewPager.setAdapter(new SliderViewAdapter(this, images));


        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer likeRate = Integer.parseInt(String.valueOf(likeRateView.getText()));
                likeRateView.setText((++likeRate).toString());
            }
        });


        unLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer unLikeRate = Integer.parseInt(String.valueOf(unLikeRateView.getText()));
                unLikeRateView.setText((++unLikeRate).toString());
            }
        });
    }
}
