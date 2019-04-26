package comt.leo.picker.moreaboutview.popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import comt.leo.picker.moreaboutview.R;


/**
 * Created by lihang Leo on 2016/6/15.
 */
public class PowWindowAdapter extends BaseAdapter {


    private Context mContext;
    private LayoutInflater mInflater;
    private String[] arr;


    public PowWindowAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }


    public void setList(String[] arr) {
        this.arr = arr;
    }

    public int getCount() {
        return arr == null ? 0 : arr.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = arr[position];
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.simple_list_text_leo, null);
            holder = new ViewHolder();
            holder.init(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(item);

        return convertView;
    }


    class ViewHolder {
        TextView text1;

        void init(View v) {
            text1 = v.findViewById(R.id.text1);
        }

    }




}
