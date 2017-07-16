package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    public boolean addSongToPlaylist(Album album, String songName) {
        if (album.getSong(songName) == null) {
            System.out.println("Song \"" + songName + "\" does not exist in album \""
                    + album.getName() + "\".");
            return false;
        }
        if (this.playlist.add(album.getSong(songName)))
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

    public List<Song> getPlaylist() {
        return playlist;
    }
}
