package listerners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import activities.HorizontalSectionList;

/**
 * Created by hawre on 2018-01-22.
 */

public class SectionListener implements MyListener {

    private Context context;
    private View view;
    private String title;

    public SectionListener(Context context, View view, String title){
        this.context = context;
        this.view = view;
        this.title = title;
        setOnItemClickListener();
    }


    @Override
    public void setOnItemClickListener() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HorizontalSectionList.class);
                context.startActivity(intent);
            }
        });
    }
}
