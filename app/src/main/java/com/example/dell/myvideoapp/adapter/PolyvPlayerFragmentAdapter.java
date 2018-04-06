package com.example.dell.myvideoapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: PolyvPlayerFragmentAdapter.java
 * @Package com.example.dell.myvideoapp.adapter
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/6 23:18
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/6 星期五  www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于伍峰教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class PolyvPlayerFragmentAdapter  extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<Fragment>();

    public PolyvPlayerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public PolyvPlayerFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}