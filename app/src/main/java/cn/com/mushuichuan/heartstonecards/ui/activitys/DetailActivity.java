package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.BaseCard;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;

public class DetailActivity extends BaseActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_ID = "EXTRA_ID";
    private String mName, mId;
    @Bind(R.id.card_img)
    ImageView mImg;
    @Bind(R.id.detail_attack)
    TextView mAttack;
    @Bind(R.id.detail_cardset)
    TextView mCardSet;
    @Bind(R.id.detail_collectible)
    TextView mCollectible;
    @Bind(R.id.detail_cost)
    TextView mCost;
    @Bind(R.id.detail_flavour)
    TextView mFlavour;
    @Bind(R.id.detail_health)
    TextView mHealth;
    @Bind(R.id.detail_menutype)
    TextView mMenutype;
    @Bind(R.id.detail_rarity)
    TextView mRarity;
    @Bind(R.id.detail_text)
    TextView mText;
    @Bind(R.id.detail_race)
    TextView mRace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        mName = getIntent().getStringExtra(EXTRA_NAME);
        mId = getIntent().getStringExtra(EXTRA_ID);
        setTitle(mName);
        if (!TextUtils.isEmpty(mId)) {
            mPresenter.getSingleCard(mId);
        }

    }

    @Override
    public void onUpdate(BaseCard card) {
        Card c = (Card) card;
        picasso.load(card.img).fit().placeholder(R.mipmap.card_back_default).centerInside().into(mImg);
        mAttack.setText(getString(R.string.attack, c.attack));
        mCardSet.setText(getString(R.string.card_set, c.cardSet));
        mCollectible.setText(getString(R.string.collectible, c.collectible));
        mCost.setText(getString(R.string.cost, c.cost));
        mFlavour.setText(getString(R.string.flavor, c.flavor));
        mHealth.setText(getString(R.string.health, c.health));
        mMenutype.setText(getString(R.string.menu_type, c.menuType));
        mRarity.setText(getString(R.string.rarity, c.rarity));
        mRace.setText(getString(R.string.rarity, c.race));
        mText.setText(getString(R.string.text, c.text));

    }
}
