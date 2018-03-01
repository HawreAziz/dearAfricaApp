package activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.CommentListItemAdapter;
import adapters.SliderViewAdapter;
import custom.classes.CommentBoxHolder;
import listerners.DoCommentListener;
import listerners.FloatingButtonListener;
import listerners.RateWidgetListener;
import utils.SharedConstants;


public class TopicActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private EditText commentInput;

    //for test purpose only, should be removed later when the real database is up
    private Integer[] images = {R.drawable.social_media, R.drawable.tick_image};

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        viewPager = findViewById(R.id.whatsUpSlider);
        ImageButton sendBtn = findViewById(R.id.sendButton);


        EditText commentTextWidget = findViewById(R.id.commentText);
        //ImageButton shareBtn = findViewById(R.id.shareIcon);
        //shareTextWdiget = findViewById(R.id.shareText);




        ImageButton likeBtn = findViewById(R.id.likeButton);
        ImageButton unLikeBtn = findViewById(R.id.unLikeButton);
        EditText likeRateView = findViewById(R.id.likeRate);
        EditText unLikeRateView = findViewById(R.id.unLikeRate);



        RecyclerView commentList = findViewById(R.id.commentRecyclerView);
        EditText doCommentText = findViewById(R.id.commentText);
        ImageButton doCommentIcon = findViewById(R.id.commentIcon);
        commentInput = findViewById(R.id.commentBox);
        ScrollView scrollView = findViewById(R.id.scrollView);
        EditText commentBox = findViewById(R.id.commentBox);
        scrollView = findViewById(R.id.scrollView);

        commentList.setNestedScrollingEnabled(false);

        FloatingActionButton upArrow = findViewById(R.id.floatingUpArrow);
        FloatingActionButton downArrow = findViewById(R.id.floatingDownArrow);

        scrollView.smoothScrollTo(0, 0);


        commentBox.setWidth(SharedConstants.screen_width - 140);

        sendBtn.setEnabled(false);
        commentInput.clearFocus();


        commentList.setHasFixedSize(true);
        commentList.setLayoutManager(new LinearLayoutManager(this));

        List<CommentBoxHolder> commentBoxHodlers = new ArrayList<>();
        for(int i=0; i<10; i++){
            commentBoxHodlers.add(new CommentBoxHolder(R.drawable.head_profile,
                    "Hawre Aziz", "This is comment number " + i));
        }



        new FloatingButtonListener(upArrow, downArrow, scrollView);


        // set adapters
        commentList.setAdapter(new CommentListItemAdapter(this, commentBoxHodlers));
        viewPager.setAdapter(new SliderViewAdapter(this, images));


        // set listeners
        new RateWidgetListener(likeBtn, likeRateView);
        new RateWidgetListener(unLikeBtn, unLikeRateView);



        new DoCommentListener(this, commentTextWidget, commentInput,
                               doCommentIcon, sendBtn, commentBoxHodlers, commentList, scrollView);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        commentInput.clearFocus();
        return super.dispatchTouchEvent(ev);
    }
}





