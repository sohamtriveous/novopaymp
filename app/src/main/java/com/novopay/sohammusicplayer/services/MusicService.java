package com.novopay.sohammusicplayer.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.novopay.sohammusicplayer.events.MusicCompletedEvent;

import de.greenrobot.event.EventBus;
import hugo.weaving.DebugLog;

/**
 * Created by sohammondal on 05/08/15.
 */
public class MusicService extends Service {
    private static MediaPlayer mediaPlayer;

    public static final String KEY_METHOD = "method";

    public static final String METHOD_PLAY = "method_play";
    public static final String METHOD_PAUSE = "method_pause";
    public static final String METHOD_STOP = "method_stop";
    public static final String METHOD_FF = "method_ff";
    public static final String METHOD_RW = "method_rw";

    public static int getCurrentPosition() {
        if(mediaPlayer!=null) {
            if(mediaPlayer.isPlaying()) {
                return mediaPlayer.getCurrentPosition();
            }
        }
        return -1;
    }

    @Override
    @DebugLog
    public int onStartCommand(Intent intent, int flags, int startId) {
        String method = intent.getStringExtra(KEY_METHOD);
        if(method.equals(METHOD_PLAY)) {

        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                EventBus.getDefault().post(new MusicCompletedEvent());
            }
        });


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    @DebugLog
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void startPlaying(final Context context) {
        Intent intent = new Intent(context, MusicService.class);
        intent.putExtra(MusicService.KEY_METHOD, METHOD_PLAY);
        context.startService(intent);
    }
}
