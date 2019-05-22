package comt.leo.picker.moreaboutview.recyclerflow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import comt.leo.picker.moreaboutview.R;

/**
 * Created by chenxiaoping on 2017/3/28.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;

    private int[] mColors = {R.mipmap.wangze1,
            R.mipmap.wangze2,
            R.mipmap.wangze3,
            R.mipmap.wangze4,
            R.mipmap.wangze5,
            R.mipmap.wangze6};

    private onItemClick clickCb;

    public Adapter(Context c) {
        mContext = c;
    }

    public Adapter(Context c, onItemClick cb) {
        mContext = c;
        clickCb = cb;
    }

    public void setOnClickLstn(onItemClick cb) {
        this.clickCb = cb;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Glide.with(mContext).load(mColors[position % mColors.length])
//                .into(holder.img);
        holder.img.setImageResource(mColors[position % mColors.length]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCb != null) {
                    clickCb.clickItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public interface onItemClick {
        void clickItem(int pos);
    }
}
