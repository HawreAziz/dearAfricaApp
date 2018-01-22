package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import custom.classes.Topic;

/**
 * Created by hawre on 2018-01-11.
 */

public class ListViewAdapter extends ArrayAdapter<Topic> {


    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Topic> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_list_view_row, null);
        }

        Topic topic = getItem(position);
        TextView titleView = view.findViewById(R.id.listViewRowTitle);
        TextView descView = view.findViewById(R.id.listViewRowDesc);
        TextView timeView = view.findViewById(R.id.listViewRowTime);
        ImageView imageView = view.findViewById(R.id.listViewRowImage);

        imageView.setImageResource(topic.getImageId());
        titleView.setText(topic.getTitle());
        descView.setText(topic.getDescription());
        timeView.setText(topic.getTime());
        return view;
    }
}
