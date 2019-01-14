package comt.leo.picker.moreaboutview.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/13.
 */

public class NewImpressItemBean implements Serializable {
    private String code;
    private String remark;

    private boolean isMore;

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    private ArrayList<ImpressSonBean> tagList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ArrayList<ImpressSonBean> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<ImpressSonBean> tagList) {
        this.tagList = tagList;
    }
}
