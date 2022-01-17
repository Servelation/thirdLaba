package com.example.thirdlaba;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class MainActivity extends Activity {
    private final static long ONE_SECOND = 1_000;
    private static final TimerModel timerModel = new TimerModel(0, 0 , 0);
    private static volatile boolean isRunning;
    private TimerView timerView;
    private volatile boolean isHidden;
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.startButton);
        Button stopButton = findViewById(R.id.stopButton);
        Button resetButton = findViewById(R.id.resetButton);

        TextView hoursView = findViewById(R.id.hoursTextView);
        TextView minutesView = findViewById(R.id.minutesTextView);
        TextView secondsView = findViewById(R.id.secondsTextView);

        timerView = new TimerView(hoursView, minutesView, secondsView);
        isHidden = false;
        startButton.setOnClickListener(v -> {
            if (isRunning) {
                return;
            }
            isRunning = true;
            mHandler.postDelayed(this::update, ONE_SECOND);
        });
        stopButton.setOnClickListener(v -> {
            isRunning = false;
        });
        resetButton.setOnClickListener(v -> {
            isRunning = false;
            timerModel.reset();
            timerView.updateState(timerModel);
        });
        timerView.updateState(timerModel);
    }

    private void update() {
        if (isRunning && !isHidden) {
            timerModel.tick();
            timerView.updateState(timerModel);
            mHandler.postDelayed(this::update, ONE_SECOND);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isHidden = false;
        mHandler.postDelayed(this::update, ONE_SECOND);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isHidden = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isHidden = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}