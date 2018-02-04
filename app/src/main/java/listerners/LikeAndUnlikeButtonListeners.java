package listerners;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by hawre on 2018-02-04.
 */

public class LikeAndUnlikeButtonListeners {
    private boolean liked;
    private ImageButton button;
    private EditText rateView;

    public LikeAndUnlikeButtonListeners(ImageButton button, EditText rateView){
        this.button = button;
        this.rateView = rateView;
        liked = false;
        setLikeOnClickListener();
    }


    // add firebase later
    public void setLikeOnClickListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer likeRate = Integer.parseInt(String.valueOf(rateView.getText()));
                likeRate = liked ? --likeRate : ++likeRate;
                liked = !liked;
                rateView.setText(likeRate.toString());
            }
        });


    }
}
