package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Album hybridTheory = new Album("Hybrid theory");

        hybridTheory.addSong("Pepercut", 3.05);
        hybridTheory.addSong("OneStepCloser", 2.37);
        hybridTheory.addSong("With you", 3.23);
        hybridTheory.addSong("Points of authority", 3.22);
        hybridTheory.addSong("Crawling", 3.31);

        Playlist playlist1 = new Playlist("LP - best");

        playlist1.addSong(hybridTheory, "Pepercut");
        playlist1.addSong(hybridTheory, "Crawling");
        playlist1.addSong(hybridTheory, "With you");
        playlist1.addSong(hybridTheory, " you");

        playlist1.printPlaylist();


        //hybridTheory.listContent();

        System.out.println("===PLAYER===");

        player(playlist1);
    }

    private static void player(/*LinkedList playlist*/Playlist playList) {
        LinkedList<Song> playlist = playList.getPlaylist();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean playingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Stopping playing songs.");
                    quit = true;
                    break;
                case 1:
                    if (!playingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        playingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached end of the playlist");
                        playingForward = false;
                    }
                    break;
                case 2:
                    if (playingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        playingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached start of the playlist");
                        playingForward = true;
                    }
                    break;
                case 3:
                    if (playingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            playingForward = false;
                        } else {
                            System.out.println("We are at the start of the list.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            playingForward = true;
                        } else
                            System.out.println("Reached the end of the list");
                    }
                    break;
                case 4:
                    playList.printPlaylist();

                    break;
                case 5:
                    listIterator.remove();
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - Play nex song\n" +
                "2 - Play previous song\n" +
                "3 - Replay song\n" +
                "4 - List the songs\n" +
                "5 - Delete current song");
    }
}
