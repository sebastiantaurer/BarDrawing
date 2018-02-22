package at.ta.se.bardrawing;

/**
 * Created by Taurer on 05.02.2018.
 */

public class BarThread extends Thread {

    private int percentage;
    private BarView barView;
    private boolean increasing;

    public BarThread(BarView barView){
        percentage = 0;
        increasing = true;
        this.barView = barView;
    }

    @Override
    public void run() {
        while(true) {
            if (increasing) {
                percentage++;
            } else {
                percentage--;
            }

            if (percentage == 200) {
                increasing = false;
            }
            if (percentage == 0) {
                increasing = true;
            }

            percentage = percentage % 200;
            barView.setRect(percentage);
            barView.postInvalidate();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
