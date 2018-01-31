package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import custom.classes.Topic;
import listerners.TopicListener;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by hawre on 2018-01-17.
 */

public class HorizontalRecyclerViewAdapter extends Adapter<HorizontalRecyclerViewAdapter.CardViewHolder> {

    private List<Topic> topics;
    private Context context;
    private TopicListener topicListener;

    public HorizontalRecyclerViewAdapter(Context context, List<Topic> topics) {
        this.topics = topics;
        this.context = context;
        topicListener = new TopicListener();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_horizontal_recycler_view_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalRecyclerViewAdapter.CardViewHolder holder, int position) {
        Topic topic = topics.get(position);
        holder.title.setText(topic.getTitle());
        holder.description.setText(topic.getDescription());
        holder.time.setText(topic.getTime());
        holder.imageView.setImageResource(topic.getImageId());
        topicListener.setOnItemClickListener(context, holder.itemView, topic.getTitle());
    }


    @Override
    public int getItemCount() {
        return topics.size();
    }


    public class CardViewHolder extends ViewHolder{
        public TextView title;
        public TextView description;
        public TextView time;
        public ImageView imageView;
        public View itemView;

        public CardViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = itemView.findViewById(R.id.hRecyclerViewTitle);
            description = itemView.findViewById(R.id.hDescription);
            time = itemView.findViewById(R.id.hRecyclerViewTime);
            imageView = itemView.findViewById(R.id.hRecyclerViewImage);
        }
    }

}
