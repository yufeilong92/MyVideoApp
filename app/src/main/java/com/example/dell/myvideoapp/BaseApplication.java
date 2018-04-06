package com.example.dell.myvideoapp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: Application.java
 * @Package com.example.dell.myvideoapp
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/6 21:58
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/6 星期五  www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于伍峰教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class BaseApplication extends Application {
    public BaseApplication() {
    }
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
