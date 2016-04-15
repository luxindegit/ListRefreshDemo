package com.example.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/4/15.
 */
public class SwipeRefreshFragment extends ListFragment {
    private SwipeRefreshLayout SwipeRefreshLayout;
    public  SwipeRefreshFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeRefreshLayout = new SwipeRefreshLayout(getActivity());

    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);

        this.SwipeRefreshLayout.addView(view);

        return this.SwipeRefreshLayout;
    }

    public void SetOnRefreshLinsener(android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener OnRefreshListener) {
        SwipeRefreshLayout.setOnRefreshListener(OnRefreshListener);
    }

    public void SetRefreshing(boolean refreshing) {
        SwipeRefreshLayout.setRefreshing(refreshing);
    }
}
