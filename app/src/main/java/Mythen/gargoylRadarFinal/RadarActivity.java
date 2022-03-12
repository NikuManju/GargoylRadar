package Mythen.gargoylRadarFinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RadarActivity extends AppCompatActivity {

    private  GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}