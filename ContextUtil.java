package demo.deepoon.com.myapplication.utils;

import android.app.Application;

/**
 * Created by YM.sheng on 2016/9/22.
 */
public class ContextUtil extends Application {

    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        //TODO Auto-generated method stub
        super.onCreate();
        instance=this;
    }

}
