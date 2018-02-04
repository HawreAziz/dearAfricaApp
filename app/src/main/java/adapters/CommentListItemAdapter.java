package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import custom.classes.CommentBoxHolder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hawre on 2018-02-04.
 */

public class CommentListItemAdapter extends RecyclerView.Adapter<CommentListItemAdapter.CommentViewHolder> {

    private Context context;
    private List<CommentBoxHolder> commentBoxHolders;


    public CommentListItemAdapter(Context context, List<CommentBoxHolder> commentBoxHolders) {
        this.context = context;
        this.commentBoxHolders = commentBoxHolders;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_comment_list_item, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        CommentBoxHolder commentBoxHolder = commentBoxHolders.get(position);
        holder.imageResource.setImageResource(commentBoxHolder.getImageResource());
        holder.userNameView.setText(commentBoxHolder.getUserName());
        holder.commentTextView.setText(commentBoxHolder.getCommentText());
    }

    @Override
    public int getItemCount() {
        return commentBoxHolders.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageResource;
        public EditText userNameView;
        public EditText commentTextView;

        public CommentViewHolder(View itemView) {
            super(itemView);
            imageResource = itemView.findViewById(R.id.profileImage);
            userNameView = itemView.findViewById(R.id.profileName);
            commentTextView = itemView.findViewById(R.id.userCommentTextView);
        }
    }
}
