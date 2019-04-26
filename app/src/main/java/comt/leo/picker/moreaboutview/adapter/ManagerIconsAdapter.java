package comt.leo.picker.moreaboutview.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import comt.leo.picker.moreaboutview.App;
import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.myView.CircleImageView;
import comt.leo.picker.moreaboutview.toast.MyToast;

/**
 * Created by lihang on 2016/4/18.
 */
public class ManagerIconsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;

    private ArrayList<String> iconList;
    private Context context;

    public ManagerIconsAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<String> iconList) {
        this.iconList = iconList;
    }

    public ArrayList<String> getLikeList() {
        return iconList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_ONE) {

            View v = mInflater.inflate(R.layout.item_managersicon, parent, false);
            holder = new ImageViewHolder(v);

        } else {

            View v = mInflater.inflate(R.layout.item_manager_text, parent, false);
            holder = new TextViewHolder(v);

        }
        return holder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ImageViewHolder) {

            final ImageViewHolder myViewHolder = (ImageViewHolder) holder;
            String item = iconList.get(position);
            ((ImageViewHolder) holder).imageView.setImageResource(R.mipmap.girl_head);
            ((ImageViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyToast.show("当前position==" + position);
                }
            });

        } else {
            final TextViewHolder myViewHolder = (TextViewHolder) holder;
            String item = iconList.get(position);
            String itemNew = item.substring(2);
            myViewHolder.text.setText(itemNew);

        }


    }


    @Override
    public int getItemViewType(int position) {

        if (iconList.get(position).contains("数字")) {
            return TYPE_TWO;
        } else {
            return TYPE_ONE;
        }

    }

    @Override
    public int getItemCount() {
        return iconList == null ? 0 : iconList.size();

    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (CircleImageView) itemView.findViewById(R.id.imageView);
        }
    }


    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public TextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
