package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import custom.classes.Topic;

/**
 * Created by hawre on 2018-01-12.
 */

public class GridViewAdapter extends ArrayAdapter<Topic> {



    public GridViewAdapter(@NonNull Context context, int resource, List<Topic> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_grid_view_item, null);
        }
        Topic topic = getItem(position);
        ImageView imageView = view.findViewById(R.id.gridViewImage);
        TextView title = view.findViewById(R.id.gridTitle);
        TextView desc = view.findViewById(R.id.gridDescription);
        TextView time = view.findViewById(R.id.gridTime);
        imageView.setImageResource(topic.getImageId());
        title.setText(topic.getTitle());
        desc.setText(topic.getDescription());
        time.setText(topic.getTime());
        return view;
    }


}
