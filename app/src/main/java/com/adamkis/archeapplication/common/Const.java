package com.adamkis.archeapplication.common;

/**
 * Created by adam on 7/25/15.
 */
public class Const {

    // Search call
//	https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=e0c4f809923709b72a9bdf1e16e08033&tags=cool&format=json&nojsoncallback=1


    public static String FLICKR_URL_BASE = "https://api.flickr.com/";
    public static String FLICKR_SERVICES_REST_ENDPOINT = "services/rest/";
    public static String FLICKR_METHOD_PARAMETER_KEY = "?method=";
    public static String FLICKR_METHOD_SEARCH_PARAMETER_VALUE = "flickr.photos.search";
    public static String FLICKR_API_KEY_PARAMETER_KEY = "&api_key=";
    public static String FLICKR_API_KEY = "e0c4f809923709b72a9bdf1e16e08033";
    public static String FLICKR_TAGS_PARAMETER_KEY = "&tags=%s";
    public static String FLICKR_FORMAT_SETUP = "&format=json";
    public static String FLICKR_JSON_CALL_BACK_SETUP = "&nojsoncallback=1";


    // TODO build URL in a better way


    public static String buildSearchUrl(String keyword){
        return String.format(
                FLICKR_URL_BASE +
                FLICKR_SERVICES_REST_ENDPOINT +
                FLICKR_METHOD_PARAMETER_KEY +
                FLICKR_METHOD_SEARCH_PARAMETER_VALUE +
                FLICKR_API_KEY_PARAMETER_KEY +
                FLICKR_API_KEY +
                FLICKR_TAGS_PARAMETER_KEY +
                FLICKR_FORMAT_SETUP +
                FLICKR_JSON_CALL_BACK_SETUP ,
                keyword
        );
    }
}
