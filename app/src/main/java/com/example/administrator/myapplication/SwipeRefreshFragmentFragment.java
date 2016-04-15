package com.example.administrator.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/15.
 */
public class SwipeRefreshFragmentFragment extends SwipeRefreshFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=super.onCreateView(inflater, container, savedInstanceState);
        final ListAdapter adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                Cheeses.randomList(20));
        setListAdapter(adapter);
        SetOnRefreshLinsener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new DummyBackgroundTask().execute();
            }
        });
        return view;
    }

    private class DummyBackgroundTask extends AsyncTask<Void, Void, List<String>> {

        static final int TASK_DURATION = 3 * 1000; // 3 seconds

        @Override
        protected List<String> doInBackground(Void... params) {
            //模拟后台操作休眠一小段时间
            try {
                Thread.sleep(TASK_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 返回20个随机数据
            return Cheeses.randomList(20);
        }

        @Override
        protected void onPostExecute(List<String> result) {
            super.onPostExecute(result);

            // 跟新完成
            onRefreshComplete(result);
        }

    }
    private void onRefreshComplete(List<String> result) {

        // 跟新ListView
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter();
        adapter.clear();
        for (String cheese : result) {
            adapter.add(cheese);
        }
        //停止刷新
        SetRefreshing(false);
    }
}
