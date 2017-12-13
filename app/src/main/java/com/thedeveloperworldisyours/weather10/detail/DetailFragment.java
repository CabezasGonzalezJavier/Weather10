package com.thedeveloperworldisyours.weather10.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.weather10.R;
import com.thedeveloperworldisyours.weather10.data.Generic;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class DetailFragment extends Fragment implements DetailContract.View {

    DetailContract.Presenter mPresenter;


    @BindView(R.id.detail_fragment_description)
    TextView mDescriptionTextView;

    @BindView(R.id.detail_fragment_temp)
    TextView mTempTextView;

    @BindView(R.id.detail_fragment_pressure)
    TextView mPressureTextView;

    @BindView(R.id.detail_fragment_humidity)
    TextView mHumidityTextView;

    @BindView(R.id.detail_fragment_temp_min)
    TextView mTempMinTextView;

    @BindView(R.id.detail_fragment_temp_max)
    TextView mTempMaxTextView;

    @BindView(R.id.detail_fragment_speed)
    TextView mSpeedTextView;

    @BindView(R.id.detail_fragment_deg)
    TextView mDirectionTextView;

    public DetailFragment() {
    }
    // Required empty public constructor

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this, view);
        mPresenter.subscribe();
        return view;
    }

    @Override
    public void showDetails(Generic generic) {
        mDescriptionTextView.setText(generic.getDescription());
        mTempTextView.setText(generic.getTemp());
        mPressureTextView.setText(generic.getPressure());
        mHumidityTextView.setText(generic.getHumidity());
        mTempMinTextView.setText(generic.getTempMin());
        mTempMaxTextView.setText(generic.getTempMax());
        mSpeedTextView.setText(generic.getSpeed());
        mDirectionTextView.setText(generic.getDeg());
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}

