package com.example.thirdlaba;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class TimerModel {
    private int hours;
    private int minutes;
    private int seconds;

    public TimerModel(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getHoursAsString() {
        return Integer.toString(hours);
    }

    public String getMinutesAsString() {
        return Integer.toString(minutes);
    }

    public String getSecondsAsString() {
        return Integer.toString(seconds);
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            minutes++;
            seconds = 0;
        }
        if (minutes == 60) {
            hours++;
            minutes = 0;
        }
    }

    public void reset() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
}
