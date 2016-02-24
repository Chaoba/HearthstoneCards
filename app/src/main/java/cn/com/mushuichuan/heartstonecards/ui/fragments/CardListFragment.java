package cn.com.mushuichuan.heartstonecards.ui.fragments;

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
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.ui.adapters.CardListAdapter;

/**
 * Created by Liyanshun on 2016/2/23.
 */
public class CardListFragment extends BaseFragment {

    private CardListAdapter adapter;

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
        getCards();
    }

    private void getCards() {
        switch (menuType) {
            case KEY_CLASSES:
                mPresenter.getCardByClass(argu);
                break;
            case KEY_FACTIONS:
                mPresenter.getCardByFaction(argu);
                break;
            case KEY_QUALITIES:
                mPresenter.getCardByQuality(argu);
                break;
            case KEY_RACES:
                mPresenter.getCardByRace(argu);
                break;
            case KEY_SETS:
                mPresenter.getCardSet(argu);
                break;
            case KEY_TYPES:
                mPresenter.getCardByType(argu);
                break;
        }
    }

    @Override
    public void onUpdate(List<Card> card) {
        super.onUpdate(card);
        adapter = new CardListAdapter(picasso, getActivity().getLayoutInflater());
        adapter.setData(card);
        mMainRecycler.setAdapter(adapter);
    }
}
