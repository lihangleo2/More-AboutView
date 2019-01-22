package comt.leo.picker.moreaboutview.activity.viewpagerandfragment.someabout;

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
 * on 2019/1/16.
 */
public class NomalSonFragment extends Fragment {
    private int position;

    public static NomalSonFragment newInstance(int position) {
        NomalSonFragment fragment = new NomalSonFragment();
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_normal, null);
        TextView text = view.findViewById(R.id.text);
        text.setText("子儿子页面 -- " + position);
        return view;
    }
}
