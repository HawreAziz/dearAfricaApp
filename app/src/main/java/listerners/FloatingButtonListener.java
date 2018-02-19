package listerners;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by HawreAz on 2018-02-18.
 */

public class FloatingButtonListener{
    private FloatingActionButton upArrow;
    private FloatingActionButton downArrow;
    private ScrollView scrollView;

    public FloatingButtonListener(final FloatingActionButton upArrow, final FloatingActionButton downArrow, final ScrollView scrollView) {
        this.upArrow = upArrow;
        this.downArrow = downArrow;
        this.scrollView = scrollView;
        setOnClickListener();

    }

    private void showButton(FloatingActionButton floatingActionButton){
        if(floatingActionButton.getVisibility() == FloatingActionButton.GONE)
            floatingActionButton.show();
    }


    private void hideButton(FloatingActionButton floatingActionButton){
        if(floatingActionButton.getVisibility() == FloatingActionButton.VISIBLE)
            floatingActionButton.hide();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setOnClickListener() {
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                View v = (View)scrollView.getChildAt(scrollView.getChildCount() - 1);
                int diff = (v.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));
                if(scrollY <= 2000){
                    hideButton(upArrow);
                    hideButton(downArrow);
                }
                if(scrollY > 2000){
                    showButton(downArrow);
                }
                if(scrollY >= 3000){
                    showButton(upArrow);
                }

                if(diff <= 5){
                    hideButton(downArrow);
                }

                upArrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(ScrollView.FOCUS_UP);
                            }
                        });
                    }
                });


                downArrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                            }
                        });
                    }
                });
            }
        });
    }
}
