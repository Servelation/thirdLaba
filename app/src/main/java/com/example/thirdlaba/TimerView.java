package com.example.thirdlaba;

import android.widget.TextView;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class TimerView {
    private TextView hoursView;
    private TextView minutesView;
    private TextView secondsView;

    public TimerView(TextView hoursView, TextView minutesView, TextView secondsView) {
        this.hoursView = hoursView;
        this.minutesView = minutesView;
        this.secondsView = secondsView;
    }

    public void updateState(TimerModel model) {
        hoursView.setText(model.getHoursAsString());
        minutesView.setText(model.getMinutesAsString());
        secondsView.setText(model.getSecondsAsString());
    }
}
