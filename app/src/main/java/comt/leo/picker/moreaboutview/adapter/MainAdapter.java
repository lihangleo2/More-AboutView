package comt.leo.picker.moreaboutview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comt.leo.picker.moreaboutview.R;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by leo
 * on 2019/1/11.
 */
public class MainAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private Context context;
    private List<String> headList;
    private List<String> bodyList;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setHeadList(List<String> headList) {
        this.headList = headList;
        notifyDataSetChanged();
    }

    public void setBodyList(List<String> bodyList) {
        this.bodyList = bodyList;
        notifyDataSetChanged();
    }

    //设置数据的个数
    @Override
    public int getCount() {
        return headList.size();
    }

    //设置item的条数
    @Override
    public Object getItem(int i) {
        return bodyList.get(i);
    }

    //获得相应数据集合中特定位置的数据项
    @Override
    public long getItemId(int i) {
        return i;
    }

    //获得头部相应数据集合中特定位置的数据项
    @Override
    public long getHeaderId(int position) {
        return position;
    }

    //绑定内容的数据
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        BodyHolder bodyHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_body, viewGroup, false);
            bodyHolder = new BodyHolder(view);
            view.setTag(bodyHolder);
        } else {
            bodyHolder = (BodyHolder) view.getTag();
        }
        //设置数据
        bodyHolder.bodyTv.setText(bodyList.get(i));

        return view;
    }

    //绑定头部的数据
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {

        HeadHolder headHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_head, parent, false);
            headHolder = new HeadHolder(convertView);
            convertView.setTag(headHolder);
        } else {
            headHolder = (HeadHolder) convertView.getTag();
        }
        //设置数据
        headHolder.headTv.setText(headList.get(position));

        return convertView;
    }


    //头部的内部类
    class HeadHolder {
        private TextView headTv;

        public HeadHolder(View itemHeadView) {

            headTv = (TextView) itemHeadView.findViewById(R.id.txHead);
        }
    }

    //内容的内部类
    class BodyHolder {
        private TextView bodyTv;

        public BodyHolder(View itemBodyView) {

            bodyTv = (TextView) itemBodyView.findViewById(R.id.txContent);
        }
    }

}
