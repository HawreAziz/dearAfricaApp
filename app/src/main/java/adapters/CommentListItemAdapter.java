package adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.whatsup.hawre.whatsup.R;

import java.util.List;

import custom.classes.CommentBoxHolder;
import interfaces.ILoadMoreListener;

/**
 * Created by hawre on 2018-02-04.
 */

public class CommentListItemAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<CommentBoxHolder> commentBoxHolders;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private ILoadMoreListener onLoadMoreListener;
    private RecyclerView recyclerView;


    public CommentListItemAdapter(Context context, List<CommentBoxHolder> commentBoxHolders, RecyclerView recyclerView) {
        this.context = context;
        this.commentBoxHolders = commentBoxHolders;
        this.recyclerView = recyclerView;

        if(recyclerView.getLayoutManager() instanceof LinearLayoutManager){
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if(!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)){
                        if(onLoadMoreListener != null){
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return commentBoxHolders.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if(viewType == VIEW_ITEM) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.activity_comment_list_item, parent, false);
            viewHolder = new CommentViewHolder(view);
        }else{
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.progress_bar, parent, false);
            viewHolder = new ProgressViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CommentViewHolder) {
            CommentBoxHolder commentBoxHolder = commentBoxHolders.get(position);
            ((CommentViewHolder)holder).imageResource.setImageResource(commentBoxHolder.getImageResource());
            ((CommentViewHolder)holder).userNameView.setText(commentBoxHolder.getUserName());
            ((CommentViewHolder)holder).commentTextView.setText(commentBoxHolder.getCommentText());
        }else{
            ((ProgressViewHolder)holder).progressBar.setIndeterminate(true);
        }
    }

    public void setLoaded(){
        loading = false;
    }

    public void setOnLoadMoreListener(ILoadMoreListener iLoadMoreListener){
        onLoadMoreListener = iLoadMoreListener;
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

    public class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar1);
        }
    }
}
