package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.ui.adapters.viewholder.DetailViewHolder;
import uk.co.ribot.easyadapter.EasyRecyclerAdapter;

public class DetailActivity extends BaseActivity {
    public static final String EXTRA_CARD = "EXTRA_CARD";
    @Bind(R.id.card_img)
    ImageView mImg;
    @Bind(R.id.fragment_main_recycler)
    RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Card card = getIntent().getParcelableExtra(EXTRA_CARD);
        mImg.setTransitionName(card.cardId);
        mList.setLayoutManager(new LinearLayoutManager(this));

        setData(card);
    }

    private void setData(Card c) {
        setTitle(c.name);
        picasso.load(c.img).fit().placeholder(R.mipmap.card_back_default).centerInside().into(mImg);
        ArrayList<Spanned> list = new ArrayList<>();
        if (c.attack != null) {
            list.add(Html.fromHtml(getString(R.string.attack, c.attack)));
        }
        if (c.health != null) {
            list.add(Html.fromHtml(getString(R.string.health, c.health)));
        }
        if (c.cost != null) {
            list.add(Html.fromHtml(getString(R.string.cost, c.cost)));
        }
        if (c.rarity != null) {
            list.add(Html.fromHtml(getString(R.string.rarity, c.rarity)));
        }
        if (c.race != null) {
            list.add(Html.fromHtml(getString(R.string.race, c.race)));
        }
        if (c.cardSet != null) {
            list.add(Html.fromHtml(getString(R.string.card_set, c.cardSet)));
        }
        if (c.collectible != null) {
            list.add(Html.fromHtml(getString(R.string.collectible, c.collectible)));
        }
        if (c.menuType != null) {
            list.add(Html.fromHtml(getString(R.string.menu_type, c.menuType)));
        }
        if (c.flavor != null) {
            list.add(Html.fromHtml(getString(R.string.flavor, c.flavor)));
        }

        if (c.text != null) {
            list.add(Html.fromHtml(getString(R.string.text, c.text)));
        }
        if (c.howToGet != null) {
            list.add(Html.fromHtml(getString(R.string.howtoget, c.howToGet)));
        }
        if (c.howToGetGold != null) {
            list.add(Html.fromHtml(getString(R.string.howtogetgold, c.howToGetGold)));
        }

        mList.setAdapter(new EasyRecyclerAdapter(this, DetailViewHolder.class, list));
    }
}
