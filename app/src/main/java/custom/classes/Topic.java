package custom.classes;

import android.graphics.drawable.ShapeDrawable;

/**
 * Created by hawre on 2018-01-11.
 */

public class Topic {
    private String title;
    private String description;
    private Integer imageId;
    private String time;

    public Topic(String title, String description, String time, Integer imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImageId() {
        return imageId;
    }
}
