package comt.leo.picker.moreaboutview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.CircleImageView;

/**
 * Created by moxun on 16/3/4.
 */
public class LeoTagsAdapter extends TagsAdapter {

    private List<String> dataSet = new ArrayList<>();

    public LeoTagsAdapter(@NonNull String... data) {
        dataSet.clear();
        Collections.addAll(dataSet, data);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.tag_item_leo, parent, false);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.circleView);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "当前的position====" + position, Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getPopularity(int position) {
        return position % 5;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor, float alpha) {
//        (CircleImageView) view.findViewById(R.id.circleView).setb;
        int color = Color.argb((int) ((1 - alpha) * 255), 255, 255, 255);
        ((CircleImageView) view.findViewById(R.id.circleView)).setColorFilter(color);
        int bordColor = Color.argb((int) ((alpha) * 255), 236, 116, 160);
        ((CircleImageView) view.findViewById(R.id.circleView)).setBorderColor(bordColor);
    }
}
