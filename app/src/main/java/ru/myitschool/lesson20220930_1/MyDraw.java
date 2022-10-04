package ru.myitschool.lesson20220930_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    Paint paint = new Paint();
    int N = 100;
    int[] rad = new int[N];
    int[] x = new int[N];
    int[] vx = new int[N];
    int[] y = new int[N];
    int[] R = new int[N];
    int[] G = new int[N];
    int[] B = new int[N];
    int[] vy = new int[N];


    public MyDraw(Context context) {
        super(context);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10f);
        initBulls();
    }

    void initBulls() {
        for (int i = 0; i < N; i++) {
            rad[i] = MyRandom(10, 50);
            x[i] = MyRandom(0, 500);
            vx[i] = MyRandom(-5, 10);
            y[i] = MyRandom(0, 500);
            R[i] = MyRandom(0, 255);
            G[i] = MyRandom(0, 255);
            B[i] = MyRandom(0, 255);
            vy[i] = MyRandom(-5, 10);
        }
    }

    public int MyRandom(int a, int b) {
        return a + (int) (Math.random() * (b - a + 1));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(R[i], G[i], B[i]));
            canvas.drawCircle(x[i], y[i], rad[i], paint);
            x[i] = (x[i] + vx[i]);
            y[i] = (y[i] + vy[i]);
            if (x[i] > canvas.getWidth() - rad[i] || x[i] - rad[i] < 0)
                vx[i] *= -1;
            if (y[i] > canvas.getHeight() - rad[i] || y[i] - rad[i] < 0)
                vy[i] *= -1;


        }

        invalidate();

    }
}
