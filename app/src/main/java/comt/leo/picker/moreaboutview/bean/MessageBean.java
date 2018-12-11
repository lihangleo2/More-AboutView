package comt.leo.picker.moreaboutview.bean;

import java.io.Serializable;

/**
 * Created by leo
 * on 2018/12/4.
 */
public class MessageBean implements Serializable {
    private int position;
    private int colorPosition;
    private String title;

    public MessageBean(int position, String title) {
        this.position = position;
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColorPosition() {
        return colorPosition;
    }

    public void setColorPosition(int colorPosition) {
        this.colorPosition = colorPosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
