package adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import activities.InfinitViewActivity;
import custom.classes.Topic;
import listerners.Listeners;

/**
 * Created by hawre on 2018-01-21.
 */

public class InfinitViewAdapter extends PagerAdapter {
    List<Topic> images;
    LayoutInflater layoutInflater;
    Context context;

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    public InfinitViewAdapter(Context context, List<Topic> images){
        this.images = images;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.activity_infinit_view_item, container, false);
        view.setClickable(true);
        ImageView imageView = view.findViewById(R.id.infiniteViewImage);
        TextView title = view.findViewById(R.id.infiniteTitle);
        TextView description = view.findViewById(R.id.infiniteDescription);
        TextView time = view.findViewById(R.id.infiniteTime);
        Topic topic = images.get(position);
        imageView.setImageResource(topic.getImageId());
        title.setText(topic.getTitle());
        description.setText(topic.getDescription());
        time.setText(topic.getTime());
        Listeners.setInfinitCycleViewListerner(context, view, topic.getTitle());
        container.addView(view);
        return view;
    }
}