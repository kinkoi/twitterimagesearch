package com.kaka.app.til.rest;

import com.twitter.sdk.android.core.AppSession;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class DataManager {
    public static void loginGuest(Callback<AppSession> callback) {
        TwitterCore.getInstance().logInGuest(callback);
    }

    public static void searchImagesUrls(AppSession session, Callback<Search> callback) {
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient(session);
        twitterApiClient.getSearchService().tweets("cat filter:images", null, null, null, null, 10, null, null, null, true, callback);
    }
}
