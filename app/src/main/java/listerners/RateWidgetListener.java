package listerners;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by HawreAz on 2018-02-15.
 */

public class RateWidgetListener {
    private ImageButton imageButton;
    private TextView textView;
    private Boolean isClicked;

    public RateWidgetListener(ImageButton imageButton, TextView textView) {
        this.imageButton = imageButton;
        this.textView = textView;
        isClicked = false;
        setButtonListener();
    }


    private void setButtonListener(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rate = Integer.parseInt(textView.getText().toString());
                textView.setText(""+ (isClicked ? --rate : ++rate));
                isClicked = !isClicked;
            }
        });
    }




}
