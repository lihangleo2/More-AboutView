package comt.leo.picker.moreaboutview.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/4/24.
 */
public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogabout);
        findViewById(R.id.buttonPanel).setOnClickListener(this);
        findViewById(R.id.buttonPane2).setOnClickListener(this);
        findViewById(R.id.buttonPane3).setOnClickListener(this);
        findViewById(R.id.buttonPane4).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPanel:
                DialogUtil.alertGreenDialog(DialogActivity.this, "是否退出登录？", "确定", "取消", new DialogUtil.DialogAlertListener() {
                    @Override
                    public void yes() {
                        Toast.makeText(DialogActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.buttonPane2:
                LockDialog lockDialog = new LockDialog(DialogActivity.this);
                lockDialog.show();
                break;

            case R.id.buttonPane3:
                LockDialog lockDialogNoBg = new LockDialog(DialogActivity.this, R.style.Dialog_nobg);
                lockDialogNoBg.show();
                break;

            case R.id.buttonPane4:
                LockBottomDialog lockDialogBottom = new LockBottomDialog(DialogActivity.this);
                lockDialogBottom.show();

                break;

        }
    }
}
