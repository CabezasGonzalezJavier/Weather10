package com.thedeveloperworldisyours.weather10.cities;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thedeveloperworldisyours.weather10.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.thedeveloperworldisyours.weather10.data.image.CreateImage.getImageFromString;
import static com.thedeveloperworldisyours.weather10.utils.Constants.FIRST_POSITION;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class CitiesAdapter extends RecyclerView
        .Adapter<CitiesAdapter
        .DataObjectHolder> {

    private Context mContext;
    private List<com.thedeveloperworldisyours.weather10.data.model.List> mResult;
    private static CitiesAdapter.ClickListener sClickListener;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        @BindView(R.id.cities_item_name_textView)
        TextView mName;

        @BindView(R.id.cities_item_imageView)
        CircleImageView mImageView;

        @BindView(R.id.cities_item_temp_textView)
        TextView mTemp;

        @BindView(R.id.cities_item_constraintLayout)
        ConstraintLayout mConstraintLayout;

        DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mConstraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition());
        }
    }
    public void setOnItemClickListener(CitiesAdapter.ClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    public CitiesAdapter(Context context, List<com.thedeveloperworldisyours.weather10.data.model.List> example) {
        mContext = context;
        mResult = example;
    }

    @Override
    public CitiesAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cities_item, parent, false);

        CitiesAdapter.DataObjectHolder dataObjectHolder = new CitiesAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(CitiesAdapter.DataObjectHolder holder, int position) {

        holder.mName.setText(mResult.get(position).getName());
        holder.mTemp.setText(String.valueOf(mResult.get(position).getMain().getTemp()));
        holder.mImageView.setImageDrawable(getImageFromString(mResult.get(position).getWeather().get(FIRST_POSITION).getMain(), mContext));

    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    interface ClickListener {
        void onItemClick(int position);
    }
}
