package study.vv.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by student2 on 22.12.17.
 */

public class Man implements SensorEventListener{
    private int xc,yc,vx;
    private Paint p=new Paint();
    Bitmap sprites;
    int frames;
    int bottom;
    public void draw(Canvas canvas){

        Rect to=new Rect(xc-86,yc-105,xc+85,yc+93);
        Rect frame=new Rect(frames*165,bottom,(frames+1)*162,bottom+186);
        canvas.drawBitmap(this.sprites,frame,to,p);
    }
    Man(int x,int y,Bitmap sprite){
        this.xc=x;
        this.yc=y;
        this.vx=0;
        this.sprites=sprite;
        bottom=0;
    }
    void move(){
        MainActivity.sm.registerListener(this,MainActivity.accel, SensorManager.SENSOR_DELAY_GAME);
        if(vx!=0) {
            frames++;
            if (frames >= 8)
                frames = 0;
            if (vx>0)
                bottom = 0;
            else if (vx < 0)
                bottom = 210;
        }
        this.xc+=vx;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]<-2 || sensorEvent.values[1]<9){
            vx=1;
        }else if(sensorEvent.values[0]>2 || sensorEvent.values[1]<9){
            vx=-1;
        }else vx=0;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
