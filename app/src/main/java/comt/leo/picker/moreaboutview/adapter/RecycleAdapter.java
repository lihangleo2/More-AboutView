package comt.leo.picker.moreaboutview.adapter;


import android.content.Context;
import android.graphics.ColorSpace;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.bean.MessageBean;


/**
 * Created by lihang on 2018/11/28.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<MessageBean> faceList;
    private Context context;
    private View.OnClickListener clickListener;


    public RecycleAdapter(Context context, View.OnClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setData(ArrayList<MessageBean> faceList) {
        this.faceList = faceList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ietm_recycle, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        int randomnum = (int) (Math.random() * 6) + 1;
        MessageBean itemBean = faceList.get(position);
        myViewHolder.text.setText(itemBean.getTitle());
        myViewHolder.textPosition.setText(itemBean.getPosition() + "");

        if (itemBean.getColorPosition() == 0) {
            itemBean.setColorPosition(randomnum);
        }
        switch (itemBean.getColorPosition()) {
            case 1:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_2));
                break;
            case 2:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_3));
                break;
            case 3:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_4));
                break;
            case 4:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_5));
                break;
            case 5:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_6));
                break;
            case 6:
                myViewHolder.relativeBg.setBackgroundColor(context.getResources().getColor(R.color.color_1));
                break;
        }

        myViewHolder.relativeBg.setTag(itemBean);
        myViewHolder.relativeBg.setOnClickListener(clickListener);

    }


    @Override
    public int getItemCount() {
        return faceList == null ? 0 : faceList.size();
    }

    public List<MessageBean> getDataList() {
        return faceList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView textPosition;
        CardView cardView;
        RelativeLayout relativeBg;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            cardView = itemView.findViewById(R.id.cardView);
            relativeBg = itemView.findViewById(R.id.relativeBg);
            textPosition = itemView.findViewById(R.id.textPosition);
        }
    }


}
