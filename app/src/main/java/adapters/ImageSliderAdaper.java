package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bakerj.infinitecards.InfiniteCardView;
import com.whatsup.hawre.whatsup.R;

import java.util.List;

/**
 * Created by hawre on 2018-02-01.
 */

public class ImageSliderAdaper extends BaseAdapter {

    private List<Integer> images;
    private Context context;
    private InfiniteCardView inifinitCardView;

    public ImageSliderAdaper(Context context, List<Integer> images, InfiniteCardView inifinitCardView){
        this.context = context;
        this.images = images;
        this.inifinitCardView = inifinitCardView;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.image_slider_item,
                    parent, false);
        }
        convertView.setBackgroundResource(images.get(position));
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                inifinitCardView.bringCardToFront(getCount()-1);
                return false;
            }
        });
        return convertView;
    }
}
