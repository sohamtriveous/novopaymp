package com.novopay.sohammusicplayer.models;

/**
 * Created by sohammondal on 04/08/15.
 */
public class Music {
    private String songName;
    private String albumName;
    private String artistImageUrl;

    public Music(String songName, String albumName, String artistImageUrl) {
        this.songName = songName;
        this.albumName = albumName;
        this.artistImageUrl = artistImageUrl;
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

    public String getArtistImageUrl() {
        return artistImageUrl;
    }

    public void setArtistImageUrl(String artistImageUrl) {
        this.artistImageUrl = artistImageUrl;
    }
}
