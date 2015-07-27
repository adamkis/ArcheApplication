package com.adamkis.archeapplication.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adamkis.archeapplication.R;
import com.adamkis.archeapplication.model.FlickrPhotoObject;
import com.adamkis.archeapplication.network.VolleySingleton;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by adam on 7/26/15.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private final Context context;
    private List<FlickrPhotoObject> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public NetworkImageView networkImageView;

        public ViewHolder(View v) {
            super(v);
            this.mTextView = (TextView) v.findViewById(R.id.mTextView);
            this.networkImageView = (NetworkImageView) v.findViewById(R.id.networkImageView);
        }
    }


    public SearchResultAdapter(Context context, List<FlickrPhotoObject> myDataset) {
        this.mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).toString());


        holder.networkImageView.setImageUrl(
                mDataset.get(position).getPhotoUrl(),
                VolleySingleton.getInstance(context).getImageLoader());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
