package com.kaka.app.til.rest.callback;

import com.kaka.app.til.ui.twitter.callback.GeneralCallback;
import com.twitter.sdk.android.core.AppSession;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class SessionCallback extends TwitterBaseCallback<AppSession> {

    private GeneralCallback mCallback;

    public SessionCallback(GeneralCallback callback) {
        mCallback = callback;
    }

    @Override
    public void success(Result<AppSession> appSessionResult) {
        if (mCallback != null) {
            mCallback.executeAfterJoin(appSessionResult.data);
        }
    }

    @Override
    public void failure(TwitterException e) {
        super.failure(e);
        if (mCallback != null) {
            mCallback.onError(e);
        }
    }

    public void setCallback(GeneralCallback callback) {
        mCallback = callback;
    }
}
