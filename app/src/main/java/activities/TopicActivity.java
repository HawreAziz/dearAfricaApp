package activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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
import listerners.RateWidgetListener;
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
    private RecyclerView commentRecyclerView;
    private ImageButton sendBtn;




    //for test purpose only, should be removed later when the real database is up
    private Integer[] images = {R.drawable.java, R.drawable.social_media, R.drawable.tick_image};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        viewPager = findViewById(R.id.whatsUpSlider);
        sendBtn = findViewById(R.id.sendButton);

        //TextView commentTextWidget = findViewById(R.id.commentText);
        //ImageButton shareBtn = findViewById(R.id.shareIcon);
        //shareTextWdiget = findViewById(R.id.shareText);


        likeBtn = findViewById(R.id.likeButton);
        unLikeBtn = findViewById(R.id.unLikeButton);
        likeRateView = findViewById(R.id.likeRate);
        unLikeRateView = findViewById(R.id.unLikeRate);



        commentList = findViewById(R.id.commentRecyclerView);
        doCommentText = findViewById(R.id.commentText);
        doCommentIcon = findViewById(R.id.commentIcon);
        commentInput = findViewById(R.id.commentBox);
        scrollView = findViewById(R.id.scrollView);
        commentBox = findViewById(R.id.commentBox);
        commentRecyclerView = findViewById(R.id.commentRecyclerView);
        scrollView = findViewById(R.id.scrollView);


        scrollView.smoothScrollTo(0, 0);


        commentBox.setWidth(SharedConstants.screen_width - 140);

        sendBtn.setEnabled(false);
        commentInput.clearFocus();


        commentList.setHasFixedSize(true);
        commentList.setLayoutManager(new LinearLayoutManager(this));

        commentBoxHodlers = new ArrayList<>();
        for(int i=0; i<10; i++){
            commentBoxHodlers.add(new CommentBoxHolder(R.drawable.head_profile,
                    "Hawre Aziz", "This is comment number " + i));
        }



        // set adapters
        commentList.setAdapter(new CommentListItemAdapter(this, commentBoxHodlers));
        viewPager.setAdapter(new SliderViewAdapter(this, images));


        // set listeners
        new RateWidgetListener(likeBtn, likeRateView);
        new RateWidgetListener(unLikeBtn, unLikeRateView);



        doCommentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollDown();
                commentInput.requestFocus();
                showKeyboard();
            }
        });



        commentInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showKeyboard();
                commentInput.requestFocus();
                scrollDown();
            }
        });


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentBoxHodlers.add(new CommentBoxHolder(R.drawable.head_profile, "Hawre Aziz", commentInput.getText().toString()));
                commentList.getAdapter().notifyDataSetChanged();
                commentInput.setText(null);
                commentInput.clearFocus();
                sendBtn.setEnabled(false);
                scrollDown();
                hideKeyboard();

            }
        });


        doCommentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollDown();
                commentInput.requestFocus();
                showKeyboard();
            }
        });

        commentInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = commentInput.getText().toString().trim();
                if(text.isEmpty()) {
                    sendBtn.setEnabled(false);
                } else
                    sendBtn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }


    private void scrollDown(){
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void showKeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(commentInput, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(commentInput.getWindowToken(), 0);
    }

}





