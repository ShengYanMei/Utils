package demo.deepoon.com.downloaddatacopy;

import android.app.Application;

/**
 * Created by jkhhll on 2016/8/8.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerUncaughtExceptionHandler();
        LogUtils.i("sheng", "BaseApplication onCreate()");
    }

    /**
     * 注册App异常崩溃处理器
     */
    private void registerUncaughtExceptionHandler() {
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }


}
