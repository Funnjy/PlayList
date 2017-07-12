package com.company;

import java.util.ArrayList;

/**
 * Created by Anton Ilchenko on 12.07.2017.
 */
public class Album {
    private String name;
    private ArrayList<Song> albomContent;

    public Album(String name) {
        this.name = name;
        this.albomContent = new ArrayList<Song>();
    }

    public boolean addSong(String name, double duration){
        if (findeSong(name) == null){
            this.albomContent.add(new Song(name,duration));
            return true;
        }
        return false;
    }

    private Song findeSong(String name){
        for (int i = 0; i < albomContent.size(); i++) {
            Song checkedSong = this.albomContent.get(i);
            if (checkedSong.getName().equals(name)){
                return checkedSong;
            }
        }
        return null;
    }

    public Song getSong(String name){
        return findeSong(name);
    }

    public String getName() {
        return name;
    }

    public void listContent(){
        System.out.println("Album " + this.name + " contains following songs:" );
        for (int i = 0; i < albomContent.size(); i++) {
            System.out.println("Song " + (i+1) + ": " +  albomContent.get(i).getName());
        }
    }
}
