package com.example.assignment3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Animation rotateAnimation;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.ButtonStart1);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.ButtonStop1);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        imgView = (ImageView) findViewById(R.id.moonimg);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgView.startAnimation(rotateAnimation);
    }

    private void stopAnimation() {
        imgView.clearAnimation();
    }
}
