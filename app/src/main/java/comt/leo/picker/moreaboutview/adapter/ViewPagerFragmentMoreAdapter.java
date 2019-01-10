package comt.leo.picker.moreaboutview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.fragment.CategoryFragment;

/**
 * Created by Administrator on 2018/1/19.
 */

public class ViewPagerFragmentMoreAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> homeFocusBeenList;

    public ViewPagerFragmentMoreAdapter(FragmentManager fm, ArrayList<String> homeFocusBeenList) {
        super(fm);
        this.homeFocusBeenList = homeFocusBeenList;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newFragment(position);
    }

    @Override
    public int getCount() {
        return homeFocusBeenList != null ? homeFocusBeenList.size() : 0;
    }
}
