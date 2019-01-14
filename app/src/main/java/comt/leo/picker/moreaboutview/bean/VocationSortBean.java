package comt.leo.picker.moreaboutview.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/25.
 */

public class VocationSortBean implements Serializable {
    private String name;
    private String sortLetters;//显示数据拼音的首字母

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}
