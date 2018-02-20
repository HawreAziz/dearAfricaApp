package listerners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import activities.TopicActivity;
import custom.classes.CommentBoxHolder;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by hawre on 2018-02-04.
 */

public class DoCommentListener implements MyListener {
    private TopicActivity context;
    private EditText commentText;
    private ImageButton commentIcon;
    private EditText commentInput;
    private ImageButton sendButton;
    private boolean focusable;
    private RecyclerView commentList;
    private List<CommentBoxHolder> comments;
    private  ScrollView scrollView;

    public DoCommentListener(final Context context, final EditText commentText, final EditText commentInput,
                             final ImageButton commentIcon, final ImageButton sendButton, final List<CommentBoxHolder> comments,
                             final RecyclerView commentList, ScrollView scrollView) {
        this.context = (TopicActivity) context;
        focusable = false;
        this.commentList = commentList;
        this.commentText = commentText;
        this.commentIcon = commentIcon;
        this.commentInput = commentInput;
        this.sendButton = sendButton;
        this.comments = comments;
        this.scrollView = scrollView;
        sendButton.setEnabled(false);
        commentInput.clearFocus();
        setOnItemClickListener();


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
        InputMethodManager imm = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(commentInput, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(commentInput.getWindowToken(), 0);
    }

    @Override
    public void setOnItemClickListener() {
        commentText.setOnClickListener(new View.OnClickListener() {
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


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comments.add(new CommentBoxHolder(R.drawable.head_profile, "Hawre Aziz", commentInput.getText().toString()));
                commentList.getAdapter().notifyDataSetChanged();
                commentInput.setText(null);
                commentInput.clearFocus();
                sendButton.setEnabled(false);
                hideKeyboard();
                scrollDown();

            }
        });


        commentIcon.setOnClickListener(new View.OnClickListener() {
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
                    sendButton.setEnabled(false);
                } else
                    sendButton.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
