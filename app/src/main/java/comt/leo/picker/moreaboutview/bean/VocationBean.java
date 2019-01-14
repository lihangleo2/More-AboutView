package comt.leo.picker.moreaboutview.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/25.
 */

public class VocationBean implements Serializable {
    public VocationBean(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
