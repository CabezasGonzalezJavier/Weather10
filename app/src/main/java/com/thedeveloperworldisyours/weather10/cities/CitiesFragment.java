package com.thedeveloperworldisyours.weather10.cities;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.thedeveloperworldisyours.weather10.R;
import com.thedeveloperworldisyours.weather10.data.Generic;
import com.thedeveloperworldisyours.weather10.data.model.List;
import com.thedeveloperworldisyours.weather10.utils.InteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class CitiesFragment extends Fragment implements CitiesContract.View,CitiesAdapter.ClickListener {

    @BindView(R.id.cities_fragment_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.cities_fragment_retry_button)
    Button mRetry;

    @BindView(R.id.cities_fragment_constraintLayout)
    ConstraintLayout mRelativeLayout;

    @BindView(R.id.cities_fragment_recycler_view)
    RecyclerView mRecyclerView;

    CitiesAdapter mAdapter;

    CitiesContract.Presenter mPresenter;

    java.util.List<List> mElements;

    InteractionListener mListener;

    public CitiesFragment() {
        // Required empty public constructor
    }

    public static CitiesFragment newInstance() {
        return new CitiesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cities_fragment, container, false);
        ButterKnife.bind(this, view);
        mPresenter.subscribe();
        return view;
    }

    @Override
    public void setPresenter(CitiesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCities(java.util.List<List> listElements) {
        mElements = listElements;
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new CitiesAdapter(getActivity(), listElements);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void showError() {
        mProgressBar.setVisibility(View.GONE);
        mRetry.setVisibility(View.VISIBLE);
        Snackbar.make(mRelativeLayout, getActivity().getResources().getText(R.string.error_server).toString(), LENGTH_LONG).show();
        mRetry.setText(getString(R.string.retry));
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (!active) {
            mRetry.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void takeGeneric(Generic generic) {

        mListener.onFragmentInteraction(generic);
    }

    @Override
    public void onItemClick(int position) {
        mPresenter.onClickItem(mElements.get(position), getActivity().getString(R.string.no_found));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            //init the listener
            mListener = (InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }

    @OnClick(R.id.cities_fragment_retry_button)
    public void onClick(){
        setLoadingIndicator(false);
        mPresenter.fetch();
    }
}
