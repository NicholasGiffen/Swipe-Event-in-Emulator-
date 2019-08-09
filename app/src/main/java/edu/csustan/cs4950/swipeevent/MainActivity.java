package edu.csustan.cs4950.swipeevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private TextView box;
    private RelativeLayout.LayoutParams params;
    private int startX;
    private int startY;
    private int startTouchX;
    private int startTouchY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildGUI();
    }

    public void buildGUI() {
        //create a textview object
        box = new TextView(this);
        box.setBackgroundColor(0xFFFF0000);

        // create a relative layout
        RelativeLayout layout = new RelativeLayout(this);

        // add the textview object into layout
        params = new RelativeLayout.LayoutParams(300, 300);
        params.leftMargin = 100;
        params.topMargin = 200;
        layout.addView(box, params);
        setContentView(layout);

        // set touch event listener to UI component
        box.setOnTouchListener( this );
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction( );
        switch( action ) {
            case MotionEvent.ACTION_DOWN:
                startX = params.leftMargin;
                startY = params.topMargin;
                startTouchX = ( int ) event.getX( );
                startTouchY = ( int ) event.getY( );
                break;
            case MotionEvent.ACTION_MOVE:
                params.leftMargin = startX + ( int ) event.getX( ) - startTouchX;
                params.topMargin = startY + ( int ) event.getY( ) - startTouchY;
                box.setLayoutParams( params );
                break;
        }
        return true;
    }
}
