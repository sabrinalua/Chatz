package com.sabrinalua.chatz.chat;

import android.os.Binder;

import java.lang.ref.WeakReference;

/**
 * Created by sabrinalua on 09/02/2017.
 */

public class LocalBinder<S> extends Binder {
    private final WeakReference<S> mService;

    public LocalBinder(final S service) {
        mService = new WeakReference<S>(service);
    }

    public S getService() {
        return mService.get();
    }
}
