
package com.sus.immerselayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;


import java.lang.reflect.Field;

/**
 * @author ----zhaoruyang----
 * @data: 2015/7/2
 */
public class ScreenUtil {
    private static final String TAG = ScreenUtil.class.getSimpleName();

    /**
     * 用于获取状态栏的高度。
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Activity activity) {

        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            //LogHelper.e("Exception", "*****EXCEPTION*****\n", e);
        }

        return 0;

    }

    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取标题栏高度
     *
     * @param activity
     * @return
     */
    public static int getTitleBarHeight(Activity activity) {
        int contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return contentTop - getStatusBarHeight(activity);
    }

    /**
     * 在Activity中获取屏幕的高度和宽度
     *
     * @param activity 在真机中，有时候会发现得到的尺寸不是很准确，需要在AndroidManifest中添加如下配置：
     *            <supports-screens android:smallScreens="true"
     *            android:normalScreens="true" android:largeScreens="true"
     *            android:resizeable="true" android:anyDensity="true" />
     */
    public static int[] getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return new int[] {
                point.x, point.y
        };
    }

    /**
     * 在非Activity中，通常会在Custom View时
     * <p/>
     * 目前不推荐使用（3.2及以下）
     *
     * @param context 在真机中，有时候会发现得到的尺寸不是很准确，需要在AndroidManifest中添加如下配置：
     *            <supports-screens android:smallScreens="true"
     *            android:normalScreens="true" android:largeScreens="true"
     *            android:resizeable="true" android:anyDensity="true" />
     */
    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return new int[] {
                dm.widthPixels, dm.heightPixels
        };

    }

}
