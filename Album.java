package com.sunny;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name,String artist )
    {
        this.name = name;
        this.artist=artist;
        this.songs=new ArrayList<Song>();
    }
    //to check whether the song exist or not

    public Song findSong(String songname){
        for(Song checkedSong: songs){
            if(checkedSong.getSongname().equals(songname)) return checkedSong;

        }
        return null;
    }



    // to add the song in the album
    public boolean addSong(String songname, double duration){
        if(findSong(songname)==null){
            songs.add(new Song(songname,duration));
         //   System.out.println(songname+"Song added to the list");
            return true;
        }
        else{
         //   System.out.println("Song alreay exist in the list");
            return false;
        }
    }
    // to create play list
    public boolean addToPlayList(int tracknumber, LinkedList<Song> playList ) {
        int index = tracknumber - 1;// index start with 0 tracknumber start with 1 so need to -1
        if (index > 0 && index <= this.songs.size()) {
            playList.add(this.songs.get(index));
            return true;
        }
      //  System.out.println("this album does not have song with tracknumber");
        return false;

    }
        //to add to playlist

        public boolean addToPlayList(String songname, LinkedList<Song> playList ){
            for(Song checkedSong : this.songs){
                if(checkedSong.getSongname().equals(songname)){
                    playList.add(checkedSong);
                    return true;
                }
            }
         //   System.out.println("there is no such song");
            return false;
    }
}
