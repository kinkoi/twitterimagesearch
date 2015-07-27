package com.kaka.app.til.rest.callback;

import com.kaka.app.til.utils.CommonUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class TwitterBaseCallback<RESULT> extends Callback<RESULT> {
    @Override
    public void success(Result<RESULT> result) {
        CommonUtils.showToast("Success request, :" + result);
    }

    @Override
    public void failure(TwitterException e) {
        CommonUtils.showToast("Failes request, :" + e);
    }
}
