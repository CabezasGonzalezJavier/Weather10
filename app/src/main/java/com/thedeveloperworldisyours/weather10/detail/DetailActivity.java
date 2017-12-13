package com.thedeveloperworldisyours.weather10.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.thedeveloperworldisyours.weather10.R;
import com.thedeveloperworldisyours.weather10.data.Generic;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thedeveloperworldisyours.weather10.data.image.CreateImage.getImageFromString;
import static com.thedeveloperworldisyours.weather10.utils.Constants.SERIALIZABLE_GENERIC;
import static com.thedeveloperworldisyours.weather10.utils.Utils.addFragmentToActivity;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_activity_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.detail_activity_toolbar_image_view)
    ImageView mToolbarImageView;

    @BindView(R.id.detail_activity_fab)
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        ButterKnife.bind(this);

        Generic genericTwo = (Generic) getIntent().getSerializableExtra(SERIALIZABLE_GENERIC);
        initFragment(genericTwo);
        initToolBar(genericTwo);
    }

    private void initToolBar(Generic generic) {
        mToolbar.setTitle(generic.getTitle());
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbarImageView.setImageDrawable(getImageFromString(generic.getImage(), this));
        mFloatingActionButton.setImageDrawable(getImageFromString(generic.getImage(), this));
    }

    private void initFragment(Generic generic) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_activity_contentFrame);
        if (detailFragment == null) {
            detailFragment = detailFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(), detailFragment, R.id.detail_activity_contentFrame);
        }

        new DetailPresenter(generic, detailFragment);

    }

    public void back(View view) {
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishMyActivity();
                break;
        }
        return true;
    }
}
