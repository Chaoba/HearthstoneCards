package cn.com.mushuichuan.heartstonecards.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Info;
import cn.com.mushuichuan.heartstonecards.ui.adapters.FragmentMainListAdapter;
import cn.com.mushuichuan.heartstonecards.ui.adapters.RecylcerViewClickListener;

import static java.util.Collections.emptyList;

/**
 * Created by Liyanshun on 2016/2/23.
 */
public class ListFragment extends BaseFragment {
    private FragmentMainListAdapter adapter;


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
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        mPresenter.getInfo();
    }

    @Override
    public void onUpdate(Info info) {
        super.onUpdate(info);
        List<String> list = emptyList();
        switch (menuType) {
            case KEY_CLASSES:
                list = info.classes;
                break;
            case KEY_FACTIONS:
                list = info.factions;
                break;
            case KEY_QUALITIES:
                list = info.qualities;
                break;
            case KEY_RACES:
                list = info.races;
                break;
            case KEY_SETS:
                list = info.sets;
                break;
            case KEY_TYPES:
                list = info.types;
                break;
        }

        adapter = new FragmentMainListAdapter(getActivity().getLayoutInflater(), mListener);
        adapter.setData(list);
        mMainRecycler.setAdapter(adapter);
    }

    RecylcerViewClickListener mListener = new RecylcerViewClickListener() {
        @Override
        public void onClick(int poistion) {
            String item = adapter.getItem(poistion);
            Fragment fragment = new CardListFragment();
            Bundle data = new Bundle();
            data.putInt(MENU_KEY, menuType);
            data.putString(ARGU_KEY, item);
            fragment.setArguments(data);
            mActivity.showFragment(fragment, true);
        }
    };
}
