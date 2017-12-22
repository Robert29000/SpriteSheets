package study.vv.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
        man=new Man(100,200,pic);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        man.move(canvas);
        man.draw(canvas);
        invalidate();
    }

}
