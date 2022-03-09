package Mythen.gargoylRadarFinal;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;

public class MainActivity extends YouTubeBaseActivity implements View.OnClickListener{

    Button strtBtn;
    Button cnclBtn;
    Button ytbBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strtBtn = (Button) findViewById(R.id.StartButton);
        cnclBtn = (Button) findViewById(R.id.CancelButton);
        ytbBtn = (Button) findViewById(R.id.YoutubeChannelButton);

        strtBtn.setClickable(true);
        cnclBtn.setClickable(true);
        ytbBtn.setClickable(true);

        strtBtn.setOnClickListener(this);
        cnclBtn.setOnClickListener(this);
        ytbBtn.setOnClickListener(this);

        //noch start layout für fragment einfügen
    }


    @Override
    public void onClick(View v) {
        if(v.equals(strtBtn)){
            setContentView(new GameView(this));
        }
        else if(v.equals(cnclBtn)){
            System.exit(0);
        }
        else if(v.equals(ytbBtn)){

        }
    }
}