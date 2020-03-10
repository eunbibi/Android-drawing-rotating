package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class ThirdActivity extends AppCompatActivity {

    private ImageView img;
    private TextView textView;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx=300;
    private int endy=300;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);
        Spinner spinner = findViewById(R.id.spinner1);
        final List<Integer> List = new ArrayList<Integer>();

        for(int i=0;i<4;i++)
        {

            List.add(i);

        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, List);
        spinner.setAdapter(arrayAdapter);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(30);

        bitmap = Bitmap.createBitmap(getWindowManager()
                .getDefaultDisplay().getWidth(), getWindowManager()
                .getDefaultDisplay().getHeight(), ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.rgb(90, 80, 90));
        img = findViewById(R.id.img);
        img.setImageBitmap(bitmap);
        img.setVisibility(View.VISIBLE);

        canvas.drawPoint(1,1,paint);

        spinner.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {

                paint.setStrokeWidth(List.get(i));

            }
            public void onNothingSelected(AdapterView<?> arg0) {


            }

        });

        textView = findViewById(R.id.text);
        textView.setText("Use Arrow Keys to draw ! ");

    }

    public void right(View view) {
        img.setFocusable(true);
        img.requestFocus();
        endx=endx+5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        img.invalidate();
        textView.setText("Y ="+ endy);
    }

    public void down(View view) {
        img.setFocusable(true);
        img.requestFocus();
        endy=endy+5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        img.invalidate();
        textView.setText("Y ="+ endy);
    }

    public void left(View view) {
        img.setFocusable(true);
        img.requestFocus();
        endx=endx-5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        img.invalidate();
        textView.setText("Y ="+ endy);
    }

    public void up(View view) {
        img.setFocusable(true);
        img.requestFocus();
        endy=endy-5;
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
        img.invalidate();
        textView.setText("Y ="+ endy);
    }

    public void redline(View view) {
        paint.setColor(Color.RED);
    }

    public void blueline(View view) {
        paint.setColor(Color.BLUE);
    }

    public void yellowline(View view) {
        paint.setColor(Color.YELLOW);
    }

    public void clearall(View view) {
        canvas.drawColor(Color.rgb(95, 75, 92));
        startx = 20;
        starty = 20;
        endx = 300;
        endy = 300;
        textView.setText("Use Arrow Keys to draw ");
    }
}
