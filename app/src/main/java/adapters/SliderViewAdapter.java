package adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.whatsup.hawre.whatsup.R;

/**
 * Created by hawre on 2018-01-13.
 */

public class SliderViewAdapter extends PagerAdapter {

    private Context context;
    private Integer[] images;

    public SliderViewAdapter(Context context, Integer[] images) {

        this.context = context;
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_slider_image_item, null);
        ImageView imageView = view.findViewById(R.id.SliderImageItem);
        imageView.setImageResource(images[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        ViewPager viewPager  = (ViewPager) container;
        viewPager.removeView(view);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
