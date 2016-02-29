package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.BaseCard;

public class DetailActivity extends BaseActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    private String mName;
    @Bind(R.id.card_img)
    ImageView mImg;
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
        setTitle(mName);
        if (!TextUtils.isEmpty(mName)) {
            mPresenter.getSingleCard(mName);
        }

    }

    @Override
    public void onUpdate(BaseCard card) {
        picasso.load(card.img).fit().placeholder(R.mipmap.card_back_default).centerInside().into(mImg);
    }
}
