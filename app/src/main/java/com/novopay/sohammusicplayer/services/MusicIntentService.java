package com.novopay.sohammusicplayer.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by sohammondal on 05/08/15.
 */
public class MusicIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MusicIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
