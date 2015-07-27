package com.adamkis.archeapplication.ui;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.adamkis.archeapplication.R;
import com.adamkis.archeapplication.common.Const;
import com.adamkis.archeapplication.model.FlickrSearchResponse;
import com.adamkis.archeapplication.network.GsonRequest;
import com.adamkis.archeapplication.network.VolleySingleton;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private NetworkImageView networkImageView;
        private RecyclerView mRecyclerView;
        private LinearLayoutManager mLayoutManager;
        private SearchResultAdapter mAdapter;
        private Dialog loadingDialog;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);


            loadingDialog = new Dialog(getActivity() ,android.R.style.Theme_Translucent_NoTitleBar);
//            loadingDialog = new Dialog(getActivity());
//            loadingDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            loadingDialog.setContentView(R.layout.dialog_loading);
            loadingDialog.show();

            download();

            return rootView;
        }


        @Override
        public void onPause() {
            super.onPause();
            if( loadingDialog != null ){
                loadingDialog.dismiss();
            }
        }

        private void download(){

            Log.i("LOG", "Call made!");


            GsonRequest jsObjRequest = new GsonRequest(
                Const.buildSearchUrl("cool"),
                FlickrSearchResponse.class,
                null,
                new Response.Listener<FlickrSearchResponse>() {

                    @Override
                    public void onResponse(FlickrSearchResponse response) {
                        Log.i("LOG", "FlickrSearchResponse: " + response.toString());
                        Log.i("LOG", "Photo url: " + response.getFlickrResponsePhotosObject().getPhotoList().get(0).getPhotoUrl());


                        // specify an adapter (see also next example)
                        mAdapter = new SearchResultAdapter(getActivity(),
                                response.getFlickrResponsePhotosObject().getPhotoList());
                        mRecyclerView.setAdapter(mAdapter);

                        loadingDialog.dismiss();

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("LOG", "VolleyError: " + error.toString());

                    }
                });


            VolleySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);
        }


    }
}
