package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.ui.adapters.CardListAdapter;
import cn.com.mushuichuan.heartstonecards.ui.fragments.BaseFragment;

public class CardListActivity extends BaseActivity {

    private RecyclerView mMainRecycler;
    private int menuType = BaseFragment.KEY_CLASSES;
    private String argu;
    private CardListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mMainRecycler = (RecyclerView) findViewById(R.id.fragment_main_recycler);
        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        menuType = getIntent().getIntExtra(BaseFragment.MENU_KEY, 0);
        argu = getIntent().getStringExtra(BaseFragment.ARGU_KEY);
        setTitle(argu);
        getCards();
    }

    private void getCards() {
        switch (menuType) {
            case BaseFragment.KEY_CLASSES:
                mPresenter.getCardByClass(argu);
                break;
            case BaseFragment.KEY_FACTIONS:
                mPresenter.getCardByFaction(argu);
                break;
            case BaseFragment.KEY_QUALITIES:
                mPresenter.getCardByQuality(argu);
                break;
            case BaseFragment.KEY_RACES:
                mPresenter.getCardByRace(argu);
                break;
            case BaseFragment.KEY_SETS:
                mPresenter.getCardSet(argu);
                break;
            case BaseFragment.KEY_TYPES:
                mPresenter.getCardByType(argu);
                break;
        }
    }

    @Override
    public void onUpdate(List<Card> card) {
        super.onUpdate(card);
        adapter = new CardListAdapter(picasso, getLayoutInflater());
        adapter.setData(card);
        mMainRecycler.setAdapter(adapter);
    }
}
