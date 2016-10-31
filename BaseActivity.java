package demo.deepoon.com.myapplication;

import android.app.Activity;
import android.os.Bundle;

import demo.deepoon.com.myapplication.ActivityCollector;

/**
 * Created by jkhhll on 2016/9/22.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加该活动
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }
}
