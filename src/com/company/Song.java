package com.company;

/**
 * Created by Anton Ilchenko on 12.07.2017.
 */
public class Song {
    private String name;
    private double duration;

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }
}