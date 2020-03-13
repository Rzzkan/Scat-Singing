package com.rzzkan.scatsinging.activity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rzzkan.scatsinging.R;
import com.rzzkan.scatsinging.tools.Tools;
import com.rzzkan.scatsinging.utils.MusicUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayerMusicAlbumSimple extends AppCompatActivity {

    private View parent_view;
    private FloatingActionButton bt_play;
    private ProgressBar song_progressbar;
    private TextView title;
    private Intent intent;
    // Media Player
    private MediaPlayer mp;
    // Handler to update UI timer, progress bar etc,.
    private Handler mHandler = new Handler();

    //private SongsManager songManager;
    private MusicUtils utils;
    private int file = 0;
    private String menu ="";
    private String tag ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_music_album_simple);
        Bundle b = getIntent().getExtras();
        if(!b.isEmpty()){
            tag = b.getString("tag");
            menu = b.getString("menu");
            file = b.getInt("file");
            initComponent();
        }

    }

    private void initComponent() {
        parent_view = findViewById(R.id.parent_view);
        bt_play = (FloatingActionButton) findViewById(R.id.bt_play);
        song_progressbar = (ProgressBar) findViewById(R.id.song_progressbar);
        title = (TextView) findViewById(R.id.file_name);

        // set title
        title.setText(menu+" "+ Integer.toString(file));
        // set Progress bar values
        song_progressbar.setProgress(0);
        song_progressbar.setMax(MusicUtils.MAX_PROGRESS);

        // Media Player
        mp = new MediaPlayer();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Changing button image to play button
                bt_play.setImageResource(R.drawable.ic_play_arrow);
            }
        });

        try {
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            AssetFileDescriptor afd = getAssets().openFd(tag+Integer.toString(file)+".mp3");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
        } catch (Exception e) {
            Snackbar.make(parent_view, "Cannot load audio file", Snackbar.LENGTH_SHORT).show();
        }

        utils = new MusicUtils();

        buttonPlayerAction();
    }

    /**
     * Play button click event plays a song and changes button to pause image
     * pauses a song and changes button to play image
     */
    private void buttonPlayerAction() {
        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // check for already playing
                if (mp.isPlaying()) {
                    mp.pause();
                    // Changing button image to play button
                    bt_play.setImageResource(R.drawable.ic_play_arrow);
                } else {
                    // Resume song
                    mp.start();
                    // Changing button image to pause button
                    bt_play.setImageResource(R.drawable.ic_pause);
                    mHandler.post(mUpdateTimeTask);
                }

            }
        });
    }

    public void controlClick(View v) {
        intent = new Intent(PlayerMusicAlbumSimple.this, PlayerMusicAlbumSimple.class);
        Bundle b = new Bundle();
        int id = v.getId();
        switch (id) {
            case R.id.bt_prev: {
                toggleButtonColor((ImageButton) v);
                if (file-1!=0){
                    b.putString("tag",tag);
                    b.putString("menu",menu);
                    b.putInt("file", file-1); //Your id
                    intent.putExtras(b); //Put your id to your next Intent
                    startActivity(intent);
                    finish();
                }
//                Snackbar.make(parent_view, "Previous", Snackbar.LENGTH_SHORT).show();
                break;
            }
            case R.id.bt_next: {
                toggleButtonColor((ImageButton) v);
                if (file+1!=9){
                    b.putString("tag",tag);
                    b.putString("menu",menu);
                    b.putInt("file", file+1); //Your id
                    intent.putExtras(b); //Put your id to your next Intent
                    startActivity(intent);
                    finish();
                }
//                Snackbar.make(parent_view, "Next", Snackbar.LENGTH_SHORT).show();
                break;
            }
        }
    }

    private boolean toggleButtonColor(ImageButton bt) {
        String selected = (String) bt.getTag(bt.getId());
        if (selected != null) { // selected
            bt.setColorFilter(getResources().getColor(R.color.red_500), PorterDuff.Mode.SRC_ATOP);
            bt.setTag(bt.getId(), null);
            return false;
        } else {
            bt.setTag(bt.getId(), "selected");
            bt.setColorFilter(getResources().getColor(R.color.red_500), PorterDuff.Mode.SRC_ATOP);
            return true;
        }
    }

    /**
     * Background Runnable thread
     */
    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            updateTimerAndSeekbar();
            // Running this thread after 10 milliseconds
            if (mp.isPlaying()) {
                mHandler.postDelayed(this, 100);
            }
        }
    };

    private void updateTimerAndSeekbar() {
        long totalDuration = mp.getDuration();
        long currentDuration = mp.getCurrentPosition();

        // Updating progress bar
        int progress = (int) (utils.getProgressSeekBar(currentDuration, totalDuration));
        song_progressbar.setProgress(progress);
    }

    // stop player when destroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mUpdateTimeTask);
        mp.release();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_setting_round, menu);
//        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.colorPrimary));
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Snackbar.make(parent_view, item.getTitle(), Snackbar.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
