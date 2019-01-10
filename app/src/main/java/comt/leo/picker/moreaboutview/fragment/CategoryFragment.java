package comt.leo.picker.moreaboutview.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/9.
 */
public class CategoryFragment extends Fragment {
    private int position;
    private TextView tv_;

    public static Fragment newFragment(int position) {
        CategoryFragment fragment = new CategoryFragment();
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment, null);
        tv_ = view.findViewById(R.id.tv_);
        tv_.setText(position + "--页面");
        return view;
    }
}
