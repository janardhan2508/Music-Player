package com.sunny;

public class Song {
    String songname;
    double duration;

    //constructor
    public Song(String songname,double duration)
    {
        this.songname=songname;
        this.duration=duration;
    }
    public Song()
    {

    }

    public String getSongname() {
        return songname;
    }

    public double getDuration() {
        return duration;
    }

    public String toString(){
        return "Song{" + "name='"+ songname+'\''+", duration=" +duration+'}';

    }
}
