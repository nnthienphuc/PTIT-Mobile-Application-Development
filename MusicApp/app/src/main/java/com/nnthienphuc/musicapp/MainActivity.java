package com.nnthienphuc.musicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    TextView tvTime, tvDuration;
    SeekBar seekBarTime, seekBarVolume;
    Button btnPlay;
    MediaPlayer musicPlayer;
    ImageView imgvolumeup, imgvolumedown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvTime = findViewById(R.id.tvTime);
        tvDuration = findViewById(R.id.tvDuration);
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        imgvolumedown = findViewById(R.id.imgvolumnedown);
        imgvolumeup = findViewById(R.id.imgvolumneup);
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(this);

        musicPlayer = MediaPlayer.create(this, R.raw.cochangtraivietlencay);
        tvDuration.setText(millisecondsToString(musicPlayer.getDuration()));

        musicPlayer.setLooping(true);
        musicPlayer.seekTo(0);
        musicPlayer.setVolume(0.5f, 0.5f);
        musicPlayer.start();

        btnPlay.setBackgroundResource(R.drawable.ic_pause);

        // Thiết lập SeekBar thời gian (tua nhạc)
        seekBarTime.setMax(musicPlayer.getDuration());
        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    musicPlayer.seekTo(i);
                    seekBar.setProgress(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Thiết lập SeekBar âm lượng
        seekBarVolume.setProgress(50);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float volume = i / 100f;
                musicPlayer.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Nút tăng âm lượng (tối đa)
        imgvolumeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentvol = musicPlayer.getDuration();
                imgvolumedown.setImageResource(R.drawable.ic_volume_down);
                musicPlayer.setVolume(currentvol, currentvol);
                seekBarVolume.setProgress(currentvol);
            }
        });

        // Nút tắt âm lượng
        imgvolumedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgvolumedown.setImageResource(R.drawable.ic_volume_down);
                musicPlayer.setVolume(0, 0);
                seekBarVolume.setProgress(0);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicPlayer != null) {
                    if (musicPlayer.isPlaying()) {
                        try {
                            final int current = musicPlayer.getCurrentPosition();
                            final String elapsedTime = millisecondsToString(current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTime.setText(elapsedTime);
                                    seekBarTime.setProgress(current);
                                }
                            });

                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // Handle exception if needed
                        }
                    }
                }
            }
        }).start();


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPlay) {
            if (musicPlayer.isPlaying()) {
                musicPlayer.pause();
                btnPlay.setBackgroundResource(R.drawable.ic_play);
            } else {
                musicPlayer.start();
                btnPlay.setBackgroundResource(R.drawable.ic_pause);
            }
        }
    }
    public String millisecondsToString(int time) {
        String elapsedTime = "";
        int minutes = time / 1000 / 60;
        int seconds = time / 1000 % 60;

        elapsedTime = minutes + ":";
        if (seconds < 10) {
            elapsedTime += "0";
        }
        elapsedTime += seconds;

        return elapsedTime;
    }
    @Override
    public void run() {
        double currentPosition = musicPlayer.getCurrentPosition();
        int total = musicPlayer.getDuration();

        while (musicPlayer != null && musicPlayer.isPlaying() && currentPosition < total) {
            try {
                Thread.sleep(1000);

                final double current = musicPlayer.getCurrentPosition();
                final String elapsedTime = millisecondsToString((int) current);
                currentPosition = current;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvTime.setText(elapsedTime);
                                seekBarTime.setProgress((int) current);
                            }
                        });
                    }
                });

            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
        }
    }

}