package activities;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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

import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;

import adapters.CommentListItemAdapter;
import adapters.SliderViewAdapter;
import custom.classes.CommentBoxHolder;
import interfaces.ILoadMoreListener;
import listerners.DoCommentListener;
import listerners.RateWidgetListener;
import utils.SharedConstants;


public class TopicActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private EditText commentInput;
    private List<CommentBoxHolder> commentBoxHolders;
    private CommentListItemAdapter commentListItemAdapter;
    protected Handler handler;
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
        //ScrollView scrollView = findViewById(R.id.scrollView);
        EditText commentBox = findViewById(R.id.commentBox);
        //scrollView = findViewById(R.id.scrollView);

        commentList.setNestedScrollingEnabled(false);

        FloatingActionButton upArrow = findViewById(R.id.floatingUpArrow);
        FloatingActionButton downArrow = findViewById(R.id.floatingDownArrow);

        //scrollView.smoothScrollTo(0, 0);


        commentBox.setWidth(SharedConstants.screen_width - 140);

        sendBtn.setEnabled(false);
        commentInput.clearFocus();


        commentList.setHasFixedSize(true);
        commentList.setLayoutManager(new LinearLayoutManager(this));
        handler = new Handler();
        commentBoxHolders = new ArrayList<>();
        /*for(int i=0; i<10; i++){
            commentBoxHolders.add(new CommentBoxHolder(R.drawable.head_profile,
                    "Hawre Aziz", "This is comment number " + i));
        }*/



        //new FloatingButtonListener(upArrow, downArrow, scrollView);


        // set adapters
        commentListItemAdapter = new CommentListItemAdapter(this, commentBoxHolders, commentList);
        commentList.setAdapter(commentListItemAdapter);
        //new AsyncLoader().execute();
        loadData();
        commentListItemAdapter.notifyDataSetChanged();


        commentListItemAdapter.setOnLoadMoreListener(new ILoadMoreListener() {
            @Override
            public void onLoadMore() {
                commentBoxHolders.add(null);
                commentListItemAdapter.notifyItemInserted(commentBoxHolders.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        commentBoxHolders.remove(commentBoxHolders.size() - 1);
                        commentListItemAdapter.notifyItemRemoved(commentBoxHolders.size());
                        int start = commentBoxHolders.size();
                        int end = start + 20;
                        for (int i = start; start < end; start++) {
                            commentBoxHolders.add(new CommentBoxHolder(R.drawable.head_profile,
                                    "Shorsh Omer", "This is the comment test"));
                        }
                        commentListItemAdapter.notifyItemInserted(commentBoxHolders.size());
                        commentListItemAdapter.setLoaded();
                }
                }, 2000);
            }
        });

        viewPager.setAdapter(new SliderViewAdapter(this, images));


        // set listeners
        new RateWidgetListener(likeBtn, likeRateView);
        new RateWidgetListener(unLikeBtn, unLikeRateView);



        new DoCommentListener(this, commentTextWidget, commentInput,
                               doCommentIcon, sendBtn, commentBoxHolders, commentList);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        commentInput.clearFocus();
        return super.dispatchTouchEvent(ev);
    }

    private void loadData() {

        for (int i = 1; i <= 20; i++) {
            commentBoxHolders.add(new CommentBoxHolder(R.drawable.head_profile, "Student " + i, "androidstudent" + i + "@gmail.com"));
        }
    }

    class AsyncLoader extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... voids) {
            for(int i=0; i<1000; i++){
                publishProgress("This is going to be a comment " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "DONE!";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            commentBoxHolders.add(new CommentBoxHolder(R.drawable.head_profile, "Hawre Aziz", ""+values));
            commentListItemAdapter.notifyDataSetChanged();
        }
    }
}





