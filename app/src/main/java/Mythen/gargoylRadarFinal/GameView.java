package Mythen.gargoylRadarFinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.logging.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Debug;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint p;
    private SurfaceHolder holder;
    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int r = 30;
        for(int i = 0; i < 5; i++){
            canvas.drawCircle(getWidth()/2,getHeight()/2,r,p);
            r+=100;
        }
    }

    private void initView(){
        holder = getHolder();
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
        Canvas can = holder.lockCanvas();
        onDraw(can);
        holder.unlockCanvasAndPost(can);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
