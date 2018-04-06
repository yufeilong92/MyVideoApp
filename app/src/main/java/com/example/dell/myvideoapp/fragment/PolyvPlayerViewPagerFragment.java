package com.example.dell.myvideoapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myvideoapp.R;
import com.example.dell.myvideoapp.adapter.PolyvPlayerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: PolyvPlayerViewPagerFragment.java
 * @Package com.example.dell.myvideoapp.fragment
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/6 23:16
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/6 星期五  www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于伍峰教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class PolyvPlayerViewPagerFragment extends Fragment {
    //fragmentView
    private View view;
    // 播放页的viewPager
    private ViewPager vp_player;
    private PolyvPlayerFragmentAdapter adapter;
    // 当前的索引
    private int currentIndex;
    private List<Fragment> lists;
    // 播放页viewpager的fragment
    private Fragment curFragment, sumFragment, talkFragment;
    private PolyvPlayerTabFragment tabFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.polyv_fragment_player_viewpager, container, false);
        return view;
    }

    private void findIdAndNew() {
        vp_player = (ViewPager) view.findViewById(R.id.vp_player);
        tabFragment = (PolyvPlayerTabFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fl_tab);
        lists = new ArrayList<Fragment>();
    }

    private void initView() {
        curFragment = new PolyvCurriculumFragment();
        lists.add(curFragment);
        for (int i = 0; i < lists.size(); i++)
            lists.get(i).setArguments(getActivity().getIntent().getExtras());
        adapter = new PolyvPlayerFragmentAdapter(getActivity().getSupportFragmentManager(), lists);
        vp_player.setAdapter(adapter);
        vp_player.setCurrentItem(0);
        currentIndex = 0;
        vp_player.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            // arg0:移动后的位置
            public void onPageSelected(int arg0) {
                currentIndex = arg0;
                tabFragment.resetViewStatus(arg0);
            }

            @Override
            // arg0:当前位置(右移)/下一位置(左移)
            // arg1:页面偏移百分比
            // arg2:页面偏移像素
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            // arg0:移动状态
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public boolean isSideIconVisible() {
        if (curFragment != null && vp_player.getCurrentItem() == 0)
            return ((PolyvCurriculumFragment) curFragment).isSideIconVisible();
        return false;
    }

    public void setSideIconVisible(boolean visiable) {
        if (curFragment != null)
            ((PolyvCurriculumFragment) curFragment).setSideIconVisible(visiable);
    }


    //改变viewpager的当前页
    public void setCurrentItem(int index) {
        vp_player.setCurrentItem(index);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

//    public PolyvTalkFragment getTalkFragment() {
//        return (PolyvTalkFragment) talkFragment;
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findIdAndNew();
        initView();
    }
}
