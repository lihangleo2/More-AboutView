package comt.leo.picker.moreaboutview.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/13.
 */

public class ImpressSonBean implements Serializable {
    private String createTime;
    private String id;
    private String lable;
    private String status;
    private int tagCount;
    private String title;
    private int leoType ;


    public int getLeoType() {
        return leoType;
    }

    public void setLeoType(int leoType) {
        this.leoType = leoType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
