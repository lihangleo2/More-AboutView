package comt.leo.picker.moreaboutview.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;


public class ScrollViewpagerAdapter extends PagerAdapter {

    ArrayList<String> mathcList;
    Context mContext;
    private View.OnClickListener listener;

    public ScrollViewpagerAdapter(Context context, View.OnClickListener listener) {
        this.mContext = context;
        this.listener = listener;
    }


    public void setMathcList(ArrayList<String> mathcList) {
        this.mathcList = mathcList;
    }

    @Override
    public int getCount() { // 获得size


        // 这个demo的精髓在于下面这行代码。让PagerAdapter的长度为Integer.MAX_VALUE
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosi = position % mathcList.size();
        String itemBean = mathcList.get(realPosi);

        RelativeLayout view = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.item_solinkhome_viewpager, null);
        TextView text_name = view.findViewById(R.id.text_name);
        text_name.setText("头条趣味 -- " + itemBean);
        container.addView(view);
        return view;
    }


}