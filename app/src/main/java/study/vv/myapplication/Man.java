package study.vv.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by student2 on 22.12.17.
 */

public class Man {
    private int xc,yc,r,vx,vy;
    private Paint p=new Paint();
    Bitmap sprites;
    public void draw(Canvas canvas){
        //canvas.drawCircle(xc,yc,r,p);
        Rect to=new Rect(xc-54,yc-70,xc+54,yc+70);
        Rect frame=new Rect(0,140,108,280);
        canvas.drawBitmap(this.sprites,frame,to,p);
    }
    Man(int x,int y,Bitmap sprite){
        this.xc=x;
        this.yc=y;
        this.vx=(int)(Math.random()*(10-5)+5);
        this.sprites=sprite;
    }
    void move(Canvas canvas){
        this.xc+=this.vx;
        if(this.xc>=canvas.getWidth() || this.xc<=0)
            this.vx=-this.vx;
    }
}
