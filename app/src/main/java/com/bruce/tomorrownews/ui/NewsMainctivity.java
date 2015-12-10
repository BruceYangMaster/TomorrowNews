package com.bruce.tomorrownews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.bruce.tomorrownews.R;
import com.bruce.tomorrownews.interf.HomeTitleBarCallBack;
import com.bruce.tomorrownews.ui.fragment.HomeTitleBarSearchActivity;
import com.bruce.tomorrownews.ui.fragment.HomeTitleFragment;
import com.bruce.tomorrownews.ui.fragment.MenuFragment;
import com.warmtel.slidingmenu.lib.SlidingMenu;
import com.warmtel.slidingmenu.lib.app.SlidingActivity;

public class NewsMainctivity extends SlidingActivity implements HomeTitleBarCallBack {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_mainctivity);
        /**
         * 添加侧滑菜单在左侧
         */
        addSlidingMenu();
        /**
         * 添加主页的title
         */
        addTitle();
    }


    /**
     * 主页title
     */
    public void addTitle() {
        /**添加fragment为主页titlebar**/
        getSupportFragmentManager().beginTransaction().add(R.id.home_title_bar, HomeTitleFragment.newInstance()).commit();
    }

    /**
     * 侧滑菜单
     */
    public void addSlidingMenu() {

        setBehindContentView(R.layout.slide_menu);
        getSupportFragmentManager().beginTransaction().add(R.id.sliding_menu_contaner_layout, MenuFragment.newInstance()).commit();

        SlidingMenu sm = getSlidingMenu();
        sm.setSlidingEnabled(true);
        sm.setMode(SlidingMenu.LEFT);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setBehindScrollScale(0.25F);
        sm.setBehindOffset(300);//侧滑菜单；离主菜单右边有多远
        sm.setFadeDegree(0.5F);
    }

    @Override
    public void toUser() {
        toggle();
        Toast.makeText(this, "home_title_bar_user", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toRefresh() {
        Toast.makeText(this, "home_title_bar_user", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toSearch() {
        Intent intent = new Intent(NewsMainctivity.this, HomeTitleBarSearchActivity.class);
        startActivity(intent);
    }
}
