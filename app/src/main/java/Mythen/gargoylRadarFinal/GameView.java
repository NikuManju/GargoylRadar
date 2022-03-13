package Mythen.gargoylRadarFinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Debug;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Paint p;
    private SurfaceHolder holder;
    private Handler handler;
    private int angle;

    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        int r = 30;
        for(int i = 0; i < 5; i++){
            canvas.drawCircle(getWidth()/2,getHeight()/2,r,p);
            r+=100;
        }
        angle+=10;
        canvas.drawLine(getWidth()/2, getHeight()/2,
                (float) (getWidth()/2-(r*Math.cos(Math.toRadians(angle)))),
                (float)(getHeight()/2-(r*Math.sin(Math.toRadians(angle)))), p);
    }

    private void initView(){
        holder = getHolder();
        handler = new Handler();
        angle = 0;
        holder.addCallback(this);
        setFocusable(true);
        SetPaint();
    }

    private void SetPaint(){
        p= new Paint();
        p.setColor(getResources().getColor(R.color.red));
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);

    }

    @SuppressLint("WrongCall")
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        handler.postDelayed(this,500);

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        handler.removeCallbacksAndMessages(null);
    }

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        synchronized (handler){
            Canvas can = holder.lockCanvas();
            onDraw(can);
            holder.unlockCanvasAndPost(can);
            handler.postDelayed(this,100);
        }

    }
}
