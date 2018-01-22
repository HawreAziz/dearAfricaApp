package adapters;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelArrayAdapter;

import java.util.List;

import object.drawables.TextDrawable;

/**
 * Created by hawre on 2018-01-10.
 */

public class WheelViewAdapter extends WheelArrayAdapter<String> {

    public WheelViewAdapter(List<String> items) {
        super(items);
    }

    public String getItem(int position) {

        return super.getItem(position);
    }

    private Drawable createCircle() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new ArcShape(0, 360));
        shapeDrawable.getPaint().setColor(1);
        return shapeDrawable;
    }

    @Override
    public Drawable getDrawable(int position) {
        Drawable[] drawable = new Drawable[] {
                createCircle(),
                new TextDrawable(getItem(position))
        };

        return new LayerDrawable(drawable);
    }
}
