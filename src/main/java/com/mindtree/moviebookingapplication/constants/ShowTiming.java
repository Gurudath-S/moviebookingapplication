package com.mindtree.moviebookingapplication.constants;

public enum ShowTiming {

    MORNING("8:00"),
    NOON("2:00"),
    EVENING("5:00"),
    NIGHT("9:00"),
	LATE("12:00");

    private String time;

    private ShowTiming(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}

