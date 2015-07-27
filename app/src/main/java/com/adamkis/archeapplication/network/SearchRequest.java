package com.adamkis.archeapplication.network;

import com.adamkis.archeapplication.model.FlickrSearchResponse;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by adam on 7/25/15.
 */
public class SearchRequest<FlickrSearchResponse> extends Request<FlickrSearchResponse> {
    private final Gson gson = new Gson();
    private final Class<FlickrSearchResponse> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<FlickrSearchResponse> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param clazz Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public SearchRequest(String url, Class<FlickrSearchResponse> clazz, Map<String, String> headers,
                       Response.Listener<FlickrSearchResponse> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(FlickrSearchResponse response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<FlickrSearchResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
