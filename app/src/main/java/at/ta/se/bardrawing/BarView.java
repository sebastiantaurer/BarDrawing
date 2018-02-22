package at.ta.se.bardrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Taurer on 05.02.2018.
 */

public class BarView extends View {

    Paint paint = new Paint();
    float startY, endY;

    public BarView(Context context) {
        super(context);
        startY = 0.0f;
        endY = 0.0f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawLine(0, this.getHeight() / 2, getWidth(), this.getHeight() / 2, paint);

        paint.setStrokeWidth(3);
        paint.setColor(Color.GREEN);
        canvas.drawRect(0, startY, this.getWidth(), endY, paint);
    }

    public void setRect(int percentage) {
        float p = percentage / 100;

        if (percentage <= 100 && percentage >= 0) {
            this.startY = (this.getHeight() / 2) * p;
            this.endY = this.getHeight() / 2;
        } else if (percentage <= 200 && percentage > 100) {
            this.startY = 0;
            this.endY = this.getHeight() * (p / 2);
        }
    }
}
