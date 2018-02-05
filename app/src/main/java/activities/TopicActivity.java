package activities;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;
import java.util.ArrayList;
import java.util.List;
import adapters.CommentListItemAdapter;
import adapters.SliderViewAdapter;
import custom.classes.CommentBoxHolder;
import listerners.DoCommentListener;
import listerners.LikeAndUnlikeButtonListeners;
import utils.SharedConstants;


public class TopicActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton likeBtn;
    private ImageButton unLikeBtn;
    private EditText shareTextWdiget;
    private EditText likeRateView;
    private EditText unLikeRateView;
    private RecyclerView commentList;
    private List<CommentBoxHolder> commentBoxHodlers;
    private EditText doCommentText;
    private ImageButton doCommentIcon;
    private EditText commentInput;
    private ScrollView scrollView;
    private EditText commentBox;
    private CardView sendCardView;




    //for test purpose only, should be removed later when the real database is up
    private Integer[] images = {R.drawable.java, R.drawable.social_media, R.drawable.tick_image};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        viewPager = findViewById(R.id.whatsUpSlider);
        likeBtn = findViewById(R.id.likeButton);
        unLikeBtn = findViewById(R.id.unLikeButton);
        ImageButton commentBtn = findViewById(R.id.commentIcon);
        TextView commentTextWidget = findViewById(R.id.commentText);
        ImageButton shareBtn = findViewById(R.id.shareIcon);
        shareTextWdiget = findViewById(R.id.shareText);
        likeRateView = findViewById(R.id.likeRate);
        unLikeRateView = findViewById(R.id.unLikeRate);
        commentList = findViewById(R.id.commentRecyclerView);
        doCommentText = findViewById(R.id.commentText);
        doCommentIcon = findViewById(R.id.commentIcon);
        commentInput = findViewById(R.id.commentBox);
        scrollView = findViewById(R.id.scrollView);
        commentBox = findViewById(R.id.commentBox);
        ImageButton sendBtn = findViewById(R.id.sendButton);
        sendCardView = findViewById(R.id.sendCardView);

        scrollView.smoothScrollTo(0, 0);

        commentBox.setWidth(SharedConstants.screen_width - 200);

        commentList.setHasFixedSize(true);
        commentList.setLayoutManager(new LinearLayoutManager(this));

        commentBoxHodlers = new ArrayList<>();
        for(int i=0; i<10; i++){
            commentBoxHodlers.add(new CommentBoxHolder(R.drawable.head_profile,
                    "Hawre Aziz", "This is comment number " + i));
        }

        commentList.setAdapter(new CommentListItemAdapter(this, commentBoxHodlers));


        viewPager.setAdapter(new SliderViewAdapter(this, images));


        new LikeAndUnlikeButtonListeners(likeBtn, likeRateView);
        new LikeAndUnlikeButtonListeners(unLikeBtn, unLikeRateView);
        new DoCommentListener(this, doCommentText, commentInput, doCommentIcon, sendBtn, sendCardView);

    }

}