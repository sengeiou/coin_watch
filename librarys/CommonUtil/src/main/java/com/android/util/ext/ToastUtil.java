package com.android.util.ext;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.util.LContext;
import com.android.util.os.DeviceUtil;

import common.util.R;

public class ToastUtil {
    private static Toast mToast;

    public static void show(int resId) {
        show(LContext.getString(resId));
    }

    public static void show(CharSequence text) {
        if (text == null || text.length() == 0) {
            return;
        }
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }

        if (mToast == null) {
            Context context = LContext.getContext();
//			mToast = Toast.makeText(LContext.getContext(), text,
//					Toast.LENGTH_SHORT);
            int d14 = DeviceUtil.dip2px(context, 14);
            int d8 = DeviceUtil.dip2px(context, 8);
            mToast = new Toast(context);
            TextView textView = new TextView(context);
            textView.setText(text);
            textView.setTextSize(15);
            textView.setTextColor(Color.WHITE);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.toast_bg);
            textView.setPadding(d14, d8, d14, d8);
            mToast.setView(textView);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showLong(int resId) {
        showLong(LContext.getString(resId));
    }

    public static void showLong(CharSequence text) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }

        if (mToast == null) {
            Context context = LContext.getContext();
//            mToast = Toast.makeText(context, text,
//					Toast.LENGTH_LONG);
            int d14 = DeviceUtil.dip2px(context, 14);
            int d8 = DeviceUtil.dip2px(context, 8);
            mToast = new Toast(context);
            TextView textView = new TextView(context);
            textView.setText(text);
            textView.setTextSize(15);
            textView.setTextColor(Color.WHITE);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.toast_bg);
            textView.setPadding(d14, d8, d14, d8);
            mToast.setView(textView);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }
}
