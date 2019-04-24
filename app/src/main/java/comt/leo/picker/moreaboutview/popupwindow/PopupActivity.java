package comt.leo.picker.moreaboutview.popupwindow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.activity.MainActivity;

/**
 * Created by leo
 * on 2019/4/24.
 */
public class PopupActivity extends AppCompatActivity implements View.OnClickListener, CommonPopupWindow.PopItemListener {
    private Button buttonPanel;
    private CommonPopupWindow popupWindow;

    private Button buttonPane2;
    private Button buttonPane3;
    private Button buttonPane4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        buttonPanel = findViewById(R.id.buttonPanel);
        buttonPanel.setOnClickListener(this);
        buttonPane2 = findViewById(R.id.buttonPane2);
        buttonPane2.setOnClickListener(this);
        buttonPane3 = findViewById(R.id.buttonPane3);
        buttonPane3.setOnClickListener(this);
        buttonPane4 = findViewById(R.id.buttonPane4);
        buttonPane4.setOnClickListener(this);
        popupWindow = new CommonPopupWindow.Builder(PopupActivity.this)
                .setView(R.layout.popup_item_one)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setOutsideTouchable(true)//在外不可用手指取消
                .setViewOnclickListener(this)
                .setAnimationStyle(R.style.MainPopAnim_top)//设置popWindow的出场动画
                .create();

//        popupWindow2 = new CommonPopupWindow.Builder(PopupActivity.this)
//                .setView(R.layout.popup_item_one)
//                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//                .setOutsideTouchable(true)//在外不可用手指取消
//                .setAnimationStyle(R.style.MainPopAnim_top)//设置popWindow的出场动画
//                .create();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPanel://向上弹出
                popupWindow.setAnimationStyle(R.style.MainPopAnim_top);
                popupWindow.showUpView(buttonPanel, 0.5f);
                break;

            case R.id.buttonPane2://向下弹出
                popupWindow.setAnimationStyle(R.style.MainPopAnim_bottom);
                popupWindow.showDownView(buttonPane2, 0.5f);
                break;

            case R.id.buttonPane3://向左弹出
                popupWindow.setAnimationStyle(R.style.MainPopAnim_left);
                popupWindow.showLeftView(buttonPane3, 0.5f);
                break;

            case R.id.buttonPane4://向右弹出
                popupWindow.setAnimationStyle(R.style.MainPopAnim_right);
                popupWindow.showRightView(buttonPane4, 0.5f);
                break;
        }
    }

    @Override
    public void getChildView(View view) {
        TextView text_hunzi = view.findViewById(R.id.text_hunzi);
        text_hunzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
