package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Album hybridTheory = new Album("Hybrid theory");

        hybridTheory.addSong("Pepercut",3.05);
        hybridTheory.addSong("OneStepCloser",2.37);
        hybridTheory.addSong("With you",3.23);
        hybridTheory.addSong("Points of authority",3.22);
        hybridTheory.addSong("Crawling",3.31);

        Playlist playlist1 = new Playlist("LP - best");

        playlist1.addSong(hybridTheory, "Pepercut");
        playlist1.addSong(hybridTheory, "Crawling");
        playlist1.addSong(hybridTheory, "With you");
        playlist1.addSong(hybridTheory, " you");

        playlist1.printPlaylist();


        //hybridTheory.listContent();

        System.out.println("===PLAYER===");

        player(playlist1);
//
//        Quit,
//        next song,
//        previous song
//        replay the current song

    }
    private static void player(/*LinkedList playlist*/Playlist playList){
        LinkedList<Song> playlist = playList.getPlaylist();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean playingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.isEmpty()){
            System.out.println("No songs in the playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().getName());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Stopping playing songs.");
                    quit = true;
                    break;
                case 1:
                    playNext(listIterator,playingForward);
                    break;
                case 2:
                    playPrevious(listIterator,playingForward);
                    break;
                case 3:
                    replayCurrent(listIterator, playingForward);
                    break;
                case 4:
                    playList.printPlaylist();
                    break;
            }
        }
    }

    private static void playNext(ListIterator<Song> iterator, boolean playingForward){
        if(!playingForward){
            if (iterator.hasNext()){
                iterator.next();
            }
            playingForward = true;
        }
        if (iterator.hasNext()){
            System.out.println("Now playing " + iterator.next().getName());
        }else {
            System.out.println("Reached end of the playlist");
            playingForward = false;
        }
    }

    private static void playPrevious(ListIterator<Song> iterator, boolean playingForward){
        if (playingForward){
            if (iterator.hasPrevious()){
                iterator.previous();
            }
            playingForward = false;
        }
        if (iterator.hasPrevious()){
            System.out.println("Now playing " + iterator.previous().getName());
        }else {
            System.out.println("Reached start of the playlist");
            playingForward = true;
        }
    }

    private static void replayCurrent(ListIterator<Song> iterator, boolean playingForward){
        if (playingForward){
            if (iterator.hasPrevious()){
                System.out.println("Now playing " + iterator.previous().getName());
                iterator.next();
            }
        }
        if (!playingForward){
            if (iterator.hasNext()){
                System.out.println("Now playing " + iterator.next().getName());
                iterator.previous();
            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - Play nex song\n" +
                "2 - Play previous song\n" +
                "3 - Replay song\n" +
                "4 - List the songs");
    }
}
