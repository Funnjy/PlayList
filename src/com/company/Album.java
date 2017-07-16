package com.company;

import java.util.ArrayList;

/**
 * Created by Anton Ilchenko on 12.07.2017.
 */
public class Album {
    private String albumName;
    private SongList songList;

    public Album(String name) {
        this.albumName = name;
        this.songList = new SongList();
    }


    public String getName() {
        return this.albumName;
    }

    public boolean addSong(String songName, double duration) {
        Song song = new Song(songName, duration);
        return this.songList.addSong(song);
    }

    public Song getSong(String songName) {
        return this.songList.getSong(songName);
    }


    private class SongList {
        private ArrayList<Song> albomContent;

        public SongList() {
            this.albomContent = new ArrayList<Song>();
        }

        public boolean addSong(Song newSong) {
            if (albomContent.contains(newSong)) {
                return false;
            }
            this.albomContent.add(newSong);
            return true;
        }

        private Song findeSong(String name) {
            for (int i = 0; i < albomContent.size(); i++) {
                Song checkedSong = this.albomContent.get(i);
                if (checkedSong.getName().equals(name)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song getSong(String name) {
            return findeSong(name);
        }
    }
}
