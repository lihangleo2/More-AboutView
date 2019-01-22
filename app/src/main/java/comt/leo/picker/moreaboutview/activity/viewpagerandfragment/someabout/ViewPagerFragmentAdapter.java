package comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/19.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mList = new ArrayList<Fragment>();

    public ViewPagerFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }
}
