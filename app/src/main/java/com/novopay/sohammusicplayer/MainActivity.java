package com.novopay.sohammusicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    @Bind(R.id.activity_main_pause)
    Button mPauseButton;
    @Bind(R.id.activity_main_seekbar)
    SeekBar seekBar;

    private MediaPlayer mediaPlayer;
    private MusicHandler musicHandler = new MusicHandler();

    @Override
    @DebugLog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.a);

        seekBar = (SeekBar) findViewById(R.id.activity_main_seekbar);

        seekBar.setMax(mediaPlayer.getDuration());

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pause is clicked", Toast.LENGTH_SHORT).show();
                musicHandler.removeMessages(MESSAGE_WAKE_UP_AND_SEEK);
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mediaPlayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.activity_main_play)
    public void onPlayButtonClick(View v) {
        Toast.makeText(MainActivity.this, "Play is clicked", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        musicHandler.sendEmptyMessage(MESSAGE_WAKE_UP_AND_SEEK);
        Log.d("MainActivity", "Starting position/Total Duration is: " + mediaPlayer.getCurrentPosition() + ", " + mediaPlayer.getDuration());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
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

    public static int MESSAGE_WAKE_UP_AND_SEEK = 10;

    class MusicHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_WAKE_UP_AND_SEEK) {
                // update the seekbar
                if (mediaPlayer != null) {
                    if(mediaPlayer.isPlaying()) {
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                        sendEmptyMessageDelayed(MESSAGE_WAKE_UP_AND_SEEK, 200);
                    }
                }
            }
        }
    }


}
