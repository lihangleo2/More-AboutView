package comt.leo.picker.moreaboutview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import comt.leo.picker.moreaboutview.R;


/**
 * Created by leo on 2019/1/15.
 */
public class EdittextDialog extends Dialog {

    private View.OnClickListener listener;
    private EditText edit_content;

    public EdittextDialog(Context context, View.OnClickListener listener) {
        this(context, R.style.MyDialogStyleBottomLeo);
        setCanceledOnTouchOutside(true);
        this.listener = listener;
//        Window dialogWindow = this.getWindow();
//        dialogWindow.setGravity(Gravity.BOTTOM);
    }


    public EdittextDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void show() {
        super.show();//设置全屏重写show方法
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_keyword);
        edit_content = findViewById(R.id.edit_content);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public EditText getEdit_content() {
        return edit_content;
    }


    public void showKeyboard() {
        if(edit_content!=null){
            //设置可获得焦点
            edit_content.setFocusable(true);
            edit_content.setFocusableInTouchMode(true);
            //请求获得焦点
            edit_content.requestFocus();
            //调用系统输入法
            InputMethodManager inputManager = (InputMethodManager) edit_content
                    .getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(edit_content, 0);
        }
    }

    public void setMaxLength(int maxLength) {
        edit_content.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public void setHint(String hintStr){
        edit_content.setHint(hintStr);
    }

}
