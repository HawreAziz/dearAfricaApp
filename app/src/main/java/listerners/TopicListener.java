package listerners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import activities.HorizontalRecyclerView;
import activities.TopicActivity;

/**
 * Created by hawre on 2018-01-29.
 */

public class TopicListener implements MyListener {
    @Override
    public void setOnItemClickListener(final Context context, View view, final String title) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, TopicActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
