package com.vardhan.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class drawView extends View {
    Paint p = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();
    Paint p4 = new Paint();
    Paint p5 = new Paint();
    Paint p6 = new Paint();
    Path path = new Path();
    Path flowerstem_center = new Path();
int deg=0;
    int dY = 0, dX = 5;
    float y = -50, x = -50;
    boolean isHorizontal = true;

    public drawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);


    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        System.out.println(getWidth());
        System.out.println(getHeight());
        float hill1_right = (float) getWidth() /8;
        float hill1_top = (float) 3* getHeight() / 4;
        float hill2_top = (float) getHeight() / 2;
        float hill2_left = (float) 7 * hill1_right;
        //Draw the sky
        p2.setColor(Color.rgb(135, 206, 235));
        canvas.drawRect(0, 0, getWidth(), getHeight(), p2);
        //Draw the hills
        p.setColor(Color.GREEN);
        canvas.drawRect(0, hill1_top , hill1_right, getHeight(), p);
        canvas.drawRect(hill2_left, hill2_top, getWidth(), getHeight(), p);
        //Fill in between the hills
        path.moveTo(hill1_right,hill1_top);
        path.lineTo(hill2_left,hill2_top);
        path.lineTo(hill2_left, getHeight());
        path.lineTo(hill1_right, getHeight());
        path.close();
        canvas.drawPath(path, p);
        //Draw the Sun
        p3.setColor(Color.rgb(249, 215, 28));
        canvas.drawCircle(getWidth() / 5, getHeight() / 7, 100, p3);
        //Draw the plant stems
        p4.setColor(Color.rgb(1, 50, 32));
            //Left Most Stem
        canvas.drawRect(hill1_right/2 - 10, hill1_top - 120, hill1_right/2 +10, hill1_top, p4);
            //Center Stem
        flowerstem_center.reset();
        flowerstem_center.moveTo((float)getWidth()/2 - 10, ((getWidth()/2 - 145) * -29 / 45)+1566);
        flowerstem_center.lineTo((float)getWidth()/2 - 10, ((getWidth()/2 - 145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth()/2 + 10, ((getWidth()/2 -145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth()/2 + 10, ((getWidth()/2 -125) * -29 / 45)+1566);
        flowerstem_center.close();
        canvas.drawPath(flowerstem_center, p4);
            //Between Left and Middle Stem
        flowerstem_center.moveTo((float)getWidth()/4 - 10, ((getWidth()/4 - 145) * -29 / 45)+1566);
        flowerstem_center.lineTo((float)getWidth()/4 - 10, ((getWidth()/4 - 145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth()/4 + 10, ((getWidth()/4 -145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth()/4 + 10, ((getWidth()/4 -125) * -29 / 45)+1566);
        flowerstem_center.close();
        canvas.drawPath(flowerstem_center, p4);
            //Between Right and Middle Stem
        flowerstem_center.moveTo((float)getWidth()*3 /4 - 10, ((getWidth()*3/4 - 145) * -29 / 45)+1566);
        flowerstem_center.lineTo((float)getWidth()* 3 /4 - 10, ((getWidth()*3/4 - 145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth() * 3/4 + 10, ((getWidth()*3/4 -145) * -29 / 45)+1566-120);
        flowerstem_center.lineTo((float)getWidth()* 3/4 + 10, ((getWidth()*3/4 -125) * -29 / 45)+1566);
        flowerstem_center.close();
        canvas.drawPath(flowerstem_center, p4);
            //Right Most Stem
        canvas.drawRect(hill1_right*15/2 - 10, hill2_top - 120, hill1_right*15/2 +10, hill2_top, p4);
        //Draw the Flowers
        p5.setColor(Color.WHITE);
        canvas.drawCircle(hill1_right/2, hill1_top - 150, 30, p5 );
        canvas.drawCircle(getWidth()/4, ((getWidth()/4 - 145) * -29 / 45)+1566-150, 30, p5 );
        canvas.drawCircle(getWidth()/2, ((getWidth()/2 - 145) * -29 / 45)+1566-150, 30, p5 );
        canvas.drawCircle(getWidth()*3/4, ((getWidth()*3/4 - 145) * -29 / 45)+1566-150, 30, p5 );
        canvas.drawCircle(hill1_right*15/2, hill2_top - 150, 30, p5);
        //Draw the Ball
        p6.setColor(Color.rgb(238, 103, 48));
        System.out.println(x);
        System.out.println(y);
        canvas.drawCircle(x, y, 50, p6);
        //Check if ball is off the screen
        if (x<0){
            x = getWidth()-50;
            y = hill2_top - 50;
        }
        //Move the ball
        if (isHorizontal){
            x -= dX;
            if (x<= hill2_left) {
                isHorizontal = false;
            }
        }
        else{
            if(x <= hill1_right) {
                isHorizontal = true;
            }
            else {
                x -= dX;
                y += dX * 29 / 45;
            }

        }
        canvas.save();
        canvas.rotate(deg--, x, y);
        canvas.drawCircle(x + 30, y +30, 10, new Paint());
        canvas.restore();
        invalidate();
    }
}
