package at.ta.se.bardrawing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BarView barView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        barView = new BarView(this);
        barView.setBackgroundColor(Color.BLUE);
        setContentView(barView);

        BarThread barThread = new BarThread(barView);
        barThread.start();

    }
}
