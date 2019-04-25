package comt.leo.picker.moreaboutview.dialog;

import android.app.Activity;
import android.view.View;

/**
 * Created by leo on 2016/12/27.
 */
public final class DialogUtil {

    private DialogUtil() {
    }

    public interface DialogAlertListener {
        void yes() ;
    }

    /*
    * 仿ios dialog
    * */
    public static void alertGreenDialog(Activity act, String message, String confirmMessage,String cancleMessage,final DialogAlertListener listener) {
        IosAlertDialogByleo dialog = new IosAlertDialogByleo(act).builder();
        dialog.setMsg(message);
        dialog.setConfirmMsg(confirmMessage);
        dialog.setConcleMsg(cancleMessage);
        dialog.setConfirmButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.yes();
            }
        });
//        dialog.setNegativeButton("取消", new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            }
//        });
        if (act != null && !act.isFinishing()) {
            dialog.show();
        }
    }





}
