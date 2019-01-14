package comt.leo.picker.moreaboutview.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;


import java.util.ArrayList;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.bean.ImpressSonBean;
import comt.leo.picker.moreaboutview.bean.NewImpressItemBean;


/**
 * Created by lihang on 2016/4/18.
 */
public class ImpressWordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<NewImpressItemBean> impressList;
    private Context context;
    private LayoutInflater inflate;
    private View.OnClickListener listener;

    public static final int TYPE_1 = 0;//显示第一印象 //  第一印象和展开的现在是统一个
    public static final int TYPE_2 = 1;//显示我对Ta的印象


    public ImpressWordAdapter(Context context, View.OnClickListener listener) {
        this.context = context;
        inflate = LayoutInflater.from(context);
        this.listener = listener;

    }

    public void setData(ArrayList<NewImpressItemBean> impressList) {
        this.impressList = impressList;
    }


    @Override
    public int getItemViewType(int position) {
        if (impressList.get(position).getCode().equals("flag")) {//第一印象
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View v;
        switch (viewType) {
            case TYPE_1://第一印象
                v = inflate.inflate(R.layout.item_new_impress_, null);
                holder = new FirstImpressHolder(v);
                break;

            case TYPE_2:
                v = inflate.inflate(R.layout.item_impress_zhank, null);
                holder = new ZhankHolder(v);
                break;

        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final NewImpressItemBean itemBean = impressList.get(position);
        if (holder instanceof FirstImpressHolder) {//第一印象
            final FirstImpressHolder firstImpressHolder = (FirstImpressHolder) holder;
            //初始化适配器
            TagAdapter tagAdapter = new TagAdapter<ImpressSonBean>(itemBean.getTagList()) {
                @Override
                public View getView(FlowLayout parent, int position, ImpressSonBean s) {
                    RelativeLayout tv = (RelativeLayout) inflate.inflate(R.layout.item_leo_flag,
                            firstImpressHolder.tagFlowLayout, false);
                    TextView text_content = (TextView) tv.findViewById(R.id.text_content);//标签内容
                    TextView text_point_num = tv.findViewById(R.id.text_point_num);//小圆点数字
                    text_content.setText("#" + s.getTitle() + "#");
                    if (s.getTagCount() > 1) {
                        text_point_num.setVisibility(View.VISIBLE);
                        text_point_num.setText(s.getTagCount() + "");
                    } else {
                        text_point_num.setVisibility(View.GONE);
                    }
                    return tv;
                }
            };
            firstImpressHolder.tagFlowLayout.setAdapter(tagAdapter);


        }  else if (holder instanceof ZhankHolder) {
            ZhankHolder zhankHolder = (ZhankHolder) holder;
            zhankHolder.text_zhankItem.setText(itemBean.getRemark());
            zhankHolder.text_zhankItem.setTag(itemBean);
            zhankHolder.text_zhankItem.setOnClickListener(listener);

        }

    }


    @Override
    public int getItemCount() {
        return impressList == null ? 0 : impressList.size();

    }

    class FirstImpressHolder extends RecyclerView.ViewHolder {//第一印象
        TagFlowLayout tagFlowLayout;
        public FirstImpressHolder(View itemView) {
            super(itemView);
            tagFlowLayout = itemView.findViewById(R.id.tagFlowLayout);
        }
    }

    class ZhankHolder extends RecyclerView.ViewHolder {//展开的那个条目
        TextView text_zhankItem;

        public ZhankHolder(View itemView) {
            super(itemView);
            text_zhankItem = itemView.findViewById(R.id.text_zhankItem);
        }
    }


}
