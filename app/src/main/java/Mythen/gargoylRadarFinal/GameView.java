package Mythen.gargoylRadarFinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint p;

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
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        SetPaint();
    }

    private void SetPaint(){
        p= new Paint();
        p.setColor(getResources().getColor(R.color.red));
        p.setStrokeWidth(5);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
