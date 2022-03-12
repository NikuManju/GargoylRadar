package Mythen.gargoylRadarFinal;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements View.OnClickListener{

    Button strtBtn;
    Button cnclBtn;
    Button ytbBtn ;
    YouTubePlayerView playerYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        strtBtn = (Button) findViewById(R.id.StartButton);
        cnclBtn = (Button) findViewById(R.id.CancelButton);
        ytbBtn = (Button) findViewById(R.id.YoutubeChannelButton);
        playerYoutube = findViewById(R.id.youtubePlayerView);

        strtBtn.setClickable(true);
        cnclBtn.setClickable(true);
        ytbBtn.setClickable(true);

        strtBtn.setOnClickListener(this);
        cnclBtn.setOnClickListener(this);
        ytbBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.equals(strtBtn)){
            Intent intent  = new Intent(this, RadarActivity.class);
            startActivity(intent);
        }
        else if(v.equals(cnclBtn)){
            System.exit(0);
        }
        else if(v.equals(ytbBtn)){
            final String videoID = "W4hTJybfU7s";
            playVideo(videoID, playerYoutube);
        }
    }

    private void playVideo(String videoID, YouTubePlayerView playerYoutube) {
        playerYoutube.initialize("AIzaSyDq1ZCCR0S6dL3UN74gbSVqj_zw5N6oA0w", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}