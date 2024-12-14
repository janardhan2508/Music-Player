package com.sunny;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums= new ArrayList<>();
    public static void main (String args[]){


        Album album=new Album("Album1", "Sunny");

        album.addSong("one", 4.5);
        album.addSong("rj", 4.0);
        album.addSong("mj", 4.2);
        albums.add(album);

        album=new Album("Album2", "Janardhan");

        album.addSong("perfect", 4.5);
        album.addSong("sad", 4.0);
        album.addSong("happy", 4.2);
        albums.add(album);

        LinkedList<Song> playList_1= new LinkedList<>();
        albums.get(0).addToPlayList("one",playList_1 );
        albums.get(1).addToPlayList("perfect", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList)
    {
        //to take the input
        Scanner sc = new Scanner(System.in);
        boolean quit=false;
        boolean forward= true;
        ListIterator<Song>listerator = playList.listIterator();

        if(playList.size()==0){
            System.out.println("This playlist is empty");
        }
        else{
            System.out.println("now playing " + listerator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Play list complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listerator.hasNext()){
                            listerator.next();
                        }
                        forward=true;
                    }
                    if(listerator.hasNext()){
                        System.out.println("now playing "+ listerator.next().toString());
                    }
                    else{
                        System.out.println("End of the List");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listerator.hasPrevious()){
                            listerator.previous();
                        }
                        forward=false;
                    }
                    if(listerator.hasPrevious()){
                        System.out.println("Now playing " + listerator.previous().toString());
                    }
                    else{
                        System.out.println("We are at the first song ");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listerator.hasPrevious()){
                            System.out.println("Now Play"+ listerator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if(listerator.hasNext()){
                            System.out.println("Now Playing"+listerator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we have reached to end of list ");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    if(playList.size()>0){
                        listerator.remove();
                        if(listerator.hasNext()){
                            System.out.println("now playing"+ listerator.next().toString());
                        }
                        else{
                            if(listerator.hasPrevious())
                            System.out.println("now playing"+ listerator.previous().toString());
                        }
                    }
            }
        }
    }

    // to take inputs
    private static void printMenu(){
        System.out.println("Available options \n press");
        System.out.println("0- to quit\n"
        + "1 - to play next song\n"
        + "2 - to play previous song\n"
        + "3 - to replay the current song\n"
        + "4 - list of all song\n"
        + "5 -  delete current song");

    }

    // print the list

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator =playlist.iterator();
        System.out.println("_______________");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________");
    }


}
