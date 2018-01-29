package listerners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import activities.HorizontalRecyclerView;
import activities.InfinitViewActivity;

/**
 * Created by hawre on 2018-01-22.
 */

public class SectionListener implements MyListener {



    @Override
    public void setOnItemClickListener(final Context context, View view, final String title) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HorizontalRecyclerView.class);
                context.startActivity(intent);
            }
        });
    }
}
