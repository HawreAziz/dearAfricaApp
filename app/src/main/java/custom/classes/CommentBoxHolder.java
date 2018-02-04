package custom.classes;

/**
 * Created by hawre on 2018-02-04.
 */

public class CommentBoxHolder {

    private Integer ImageResource;
    private String userName;
    private String commentText;

    public CommentBoxHolder(Integer imageResource, String userName, String commentText) {
        ImageResource = imageResource;
        this.userName = userName;
        this.commentText = commentText;
    }

    public void setImageResource(Integer imageResource) {
        ImageResource = imageResource;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getImageResource() {
        return ImageResource;
    }

    public String getUserName() {
        return userName;
    }

    public String getCommentText() {
        return commentText;
    }
}
