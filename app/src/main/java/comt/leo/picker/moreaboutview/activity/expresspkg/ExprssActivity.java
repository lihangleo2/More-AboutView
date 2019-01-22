package comt.leo.picker.moreaboutview.activity.expresspkg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import comt.leo.picker.moreaboutview.R;
import comt.leo.picker.moreaboutview.dialog.EdittextDialog;
import comt.leo.picker.moreaboutview.utils.KeyBoardUtils;
import io.github.rockerhieu.emojicon.EmojiconTextView;

/**
 * Created by leo
 * on 2019/1/15.
 * <p>
 * 导入module library。
 */

public class ExprssActivity extends AppCompatActivity implements View.OnClickListener {
    private EdittextDialog edittextDialog;
    private EditText edit_content;

    private EmojiconTextView txtEmojicon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);
        txtEmojicon = findViewById(R.id.txtEmojicon);
        findViewById(R.id.buttonPane2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExprssActivity.this, SingleChatActivity.class));
            }
        });
        findViewById(R.id.buttonPanel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittextDialog.show();
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        edittextDialog.showKeyboard();
                        edit_content = edittextDialog.getEdit_content();
                        setEditListener();
                    }
                }, 200);
            }
        });


        edittextDialog = new EdittextDialog(ExprssActivity.this, this);
        edittextDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                KeyBoardUtils.closeKeybord(edittextDialog.getEdit_content(), ExprssActivity.this);
                edittextDialog.getEdit_content().setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {

    }


    public void setEditListener() {//给传过来的edit_content设置监听
        edit_content.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    //发送
                    String content = edit_content.getText().toString().trim();

                    if (TextUtils.isEmpty(content)) {
                        return false;
                    }

                    txtEmojicon.setText(content);
                    edit_content.setText("");
                    edittextDialog.dismiss();
                    return true;
                }
                return false;
            }
        });
    }
}
