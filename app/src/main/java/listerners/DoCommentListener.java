package listerners;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;





import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by hawre on 2018-02-04.
 */

public class DoCommentListener {
    private Context context;
    private EditText commentText;
    private ImageButton commentIcon;
    private EditText commentInput;
    private boolean focusable;

    public DoCommentListener(final Context context, EditText commentText, final EditText commentInput,
                             ImageButton commentIcon){
        this.context = context;
        focusable = false;
        this.commentText = commentText;
        this.commentIcon = commentIcon;
        this.commentInput = commentInput;


        this.commentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentInput.setVisibility(View.VISIBLE);
                commentInput.requestFocus();

            }
        });

        this.commentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentInput.setVisibility(View.VISIBLE);
                commentInput.requestFocus();

            }
        });
        onFocusChangeListener();
        onEnterListener();
    }


    private void onFocusChangeListener(){
        commentInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                commentInput.post(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);
                        if(!focusable){
                            focusable = true;
                            imm.showSoftInput(commentInput, InputMethodManager.SHOW_IMPLICIT);
                        }else{
                            focusable = false;
                            imm.hideSoftInputFromWindow(commentInput.getWindowToken(), 0);
                            commentInput.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
    }


    private void onEnterListener(){
        commentInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        keyCode == KeyEvent.KEYCODE_ENTER){

                    commentInput.clearFocus();


                }
                return false;
            }
        });
    }

}
