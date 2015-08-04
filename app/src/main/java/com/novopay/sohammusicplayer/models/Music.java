package com.novopay.sohammusicplayer.models;

/**
 * Created by sohammondal on 04/08/15.
 */
public class Music {
    private String songName;
    private String albumName;
    private String artistName;

    public Music(String songName, String albumName, String artistName) {
        this.songName = songName;
        this.albumName = albumName;
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
