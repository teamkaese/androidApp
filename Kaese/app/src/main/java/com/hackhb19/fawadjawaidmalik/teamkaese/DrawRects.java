package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class DrawRects extends View {

    private Paint paint = new Paint();

    private int w;
    private int h;

    private String cheese;

    public DrawRects(Context context,String cheese) {
        super(context);
        this.cheese = cheese;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    public void onDraw(Canvas canvas) {

        drawIt(canvas,this.cheese);

    }

    Handler handler = new Handler();

    public void drawIt(Canvas canvas, String cheese){


                paint.setColor(Color.CYAN);
                paint.setStrokeWidth(0);
                canvas.drawRect(0.125f*w, 0.1f*h, 0.4f*w, 0.25f*h, paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(60);
                canvas.drawText("A",0.25f*w,0.19f*h,paint);

                paint.setColor(Color.YELLOW);
                paint.setStrokeWidth(0);
                canvas.drawRect(0.625f*w, 0.1f*h, 0.9f*w, 0.25f*h, paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(60);
                canvas.drawText("C",0.75f*w,0.19f*h,paint);

                paint.setColor(Color.MAGENTA);
                paint.setStrokeWidth(0);
                canvas.drawRect(0.125f*w, 0.6f*h, 0.4f*w, 0.75f*h, paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(60);
                canvas.drawText("B",0.25f*w,0.69f*h,paint);


                paint.setColor(Color.GREEN);
                paint.setStrokeWidth(0);
                canvas.drawRect(0.625f*w, 0.6f*h, 0.9f*w, 0.75f*h, paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(60);
                canvas.drawText("D",0.75f*w,0.69f*h,paint);

                paint.setColor(Color.RED);

                if(cheese.equals("Emmentaler")){ ;
                    canvas.drawCircle(0.3f*w,0.17f*h,20,paint);
                }else if(cheese.equals("Maasdammer")){
                    canvas.drawCircle(0.8f*w,0.17f*h,20,paint);
                }else{
                    canvas.drawCircle(0.3f*w,0.67f*h,20,paint);
                }

    }

}
