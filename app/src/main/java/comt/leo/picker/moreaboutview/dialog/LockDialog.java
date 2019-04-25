package comt.leo.picker.moreaboutview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.utils.KeyBoardUtils;


/**
 * Created by lihang on 2017/8/14.
 */

public class LockDialog extends Dialog {
    private EditText edit_passWord;

    public LockDialog(Context context) {
        this(context, R.style.Dialog_nomal);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }


    public LockDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    @Override
    public void show() {
        super.show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_lock_leo);
        edit_passWord = findViewById(R.id.edit_passWord);
        findViewById(R.id.text_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LockDialog.this.dismiss();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (KeyBoardUtils.isShouldHideInput(v, ev)) {
                KeyBoardUtils.closeKeybord(edit_passWord, getContext());
                edit_passWord.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }


}
