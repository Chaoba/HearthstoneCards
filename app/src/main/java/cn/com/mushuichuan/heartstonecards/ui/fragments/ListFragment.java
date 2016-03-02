package cn.com.mushuichuan.heartstonecards.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.ui.activitys.CardListActivity;
import cn.com.mushuichuan.heartstonecards.ui.adapters.FragmentMainListAdapter;
import cn.com.mushuichuan.heartstonecards.ui.adapters.RecylcerViewClickListener;

import static java.util.Collections.emptyList;

/**
 * Created by Liyanshun on 2016/2/23.
 */
public class ListFragment extends BaseFragment {
    private FragmentMainListAdapter adapter;
    private List<String> list = emptyList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainRecycler = (RecyclerView) view.findViewById(R.id.fragment_main_recycler);
        mMainRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FragmentMainListAdapter(getActivity().getLayoutInflater(), mListener);
        if (list.size() > 0) {
            adapter.setData(list);
        }
        mMainRecycler.setAdapter(adapter);
    }

    public void setData(List<String> l) {
        list = l;
        if (adapter != null) {
            adapter.setData(list);
        }

    }

    RecylcerViewClickListener mListener = new RecylcerViewClickListener() {
        @Override
        public void onClick(int poistion) {
            String item = adapter.getItem(poistion);
            Intent i = new Intent(getActivity(), CardListActivity.class);
            i.putExtra(MENU_KEY, menuType);
            i.putExtra(ARGU_KEY, item);
            startActivity(i);
        }
    };
}
