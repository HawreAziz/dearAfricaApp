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

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by hawre on 2018-01-17.
 */

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.CardViewHolder> {

    private List<Topic> topics;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Topic> topics) {
        this.topics = topics;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_recycler_view_item, parent, false);
        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Topic topic = topics.get(position);
        holder.title.setText(topic.getTitle());
        holder.description.setText(topic.getDescription());
        holder.time.setText(topic.getTime());
        holder.imageView.setImageResource(topic.getImageId());
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

        public CardViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cardViewTitle);
            description = itemView.findViewById(R.id.cardViewDescription);
            time = itemView.findViewById(R.id.cardViewTime);
            imageView = itemView.findViewById(R.id.cardViewImage);

        }
    }
}
