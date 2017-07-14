package com.company;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Anton Ilchenko on 12.07.2017.
 */
public class Playlist {
    private String playlistName;
    private LinkedList<Song> playlist;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.playlist = new LinkedList<Song>();
    }

    public boolean addSong(Album album, String name) {
        if (album.getSong(name) == null) {
            System.out.println("Song \"" + name + "\" does not exist in album \""
                    + album.getName() + "\".");
            return false;
        }
        if (playlist.add(album.getSong(name)))
            return true;
        else {
            System.out.println("Song could not be added to the playlist :(");
            return false;
        }
    }


    public void printPlaylist() {
        Iterator<Song> i = playlist.iterator();
        int o = 1;
        while (i.hasNext()) {
            System.out.println(o + " track is: " + i.next().toString());
            o++;
        }
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }
}
