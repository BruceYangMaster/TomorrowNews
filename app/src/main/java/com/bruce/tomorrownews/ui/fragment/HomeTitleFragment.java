package com.bruce.tomorrownews.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bruce.tomorrownews.R;
import com.bruce.tomorrownews.interf.HomeTitleBarCallBack;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTitleFragment extends Fragment implements View.OnClickListener {
    private ImageView mUserImage;//用户
    private TextView mRefreshText;//刷新
    private ImageView mSearchImage;//搜索

    /**
     * 申明交互接口
     **/
    public HomeTitleBarCallBack mHomeTitleCallBack;

    /**
     * 将传过来的activity转成接口实例
     *
     * @param context
     */
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof HomeTitleBarCallBack) {
            mHomeTitleCallBack = (HomeTitleBarCallBack) context;
        } else {
            throw new RuntimeException("context is not instance of MenuFragmentListener");
        }
    }

    /**
     * 通过此方法得到HomeTitleFragment实例
     *
     * @return
     */
    public static HomeTitleFragment newInstance() {

        Bundle args = new Bundle();

        HomeTitleFragment fragment = new HomeTitleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_title, container, false);
        mUserImage = (ImageView) view.findViewById(R.id.home_title_bar_user);
        mRefreshText = (TextView) view.findViewById(R.id.home_title_bar_refresh);
        mSearchImage = (ImageView) view.findViewById(R.id.home_title_bar_search);

        mUserImage.setOnClickListener(this);
        mRefreshText.setOnClickListener(this);
        mSearchImage.setOnClickListener(this);
        return view;
    }

    /**
     * 点击监听
     * 分类处理
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_title_bar_user:
                mHomeTitleCallBack.toUser();
                break;
            case R.id.home_title_bar_refresh:
                mHomeTitleCallBack.toRefresh();
                break;
            case R.id.home_title_bar_search:
                mHomeTitleCallBack.toSearch();
                break;

        }

    }
}
