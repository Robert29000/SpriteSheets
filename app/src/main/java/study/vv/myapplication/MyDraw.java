package study.vv.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.CollapsibleActionView;
import android.view.View;

/**
 * Created by student2 on 22.12.17.
 */

public class MyDraw extends View {
    Bitmap pic;
    Man man;

    public MyDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        pic= BitmapFactory.decodeResource(getResources(),R.drawable.sprites);
        man=new Man(0,200,pic);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        man.move();
        man.draw(canvas);
        invalidate();
    }

}
