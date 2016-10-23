package test.roman.maginetest.video_player;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import test.roman.maginetest.R;

public class VideoPlayerAct extends AppCompatActivity {

    public static final String VIDEO_URL = "CODE";
    private VideoView videoView;
    private MediaController mediaController;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        getSupportActionBar().hide();
        videoView = (VideoView) findViewById(R.id.video_view);
        videoUrl = getIntent().getExtras().getString(VIDEO_URL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setFormat(PixelFormat.TRANSLUCENT);

        mediaController = new MediaController(this);

        Uri video = Uri.parse(videoUrl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
//                progressDialog.dismiss();
                videoView.start();
            }
        });
    }
}
