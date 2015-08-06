
package com.novopay.sohammusicplayer.models;

import com.google.gson.annotations.Expose;

public class Collection1 {

    @Expose
    private Artistimage artistimage;
    @Expose
    private Songname songname;
    @Expose
    private Artistname artistname;
    @Expose
    private Integer index;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The artistimage
     */
    public Artistimage getArtistimage() {
        return artistimage;
    }

    /**
     * 
     * @param artistimage
     *     The artistimage
     */
    public void setArtistimage(Artistimage artistimage) {
        this.artistimage = artistimage;
    }

    /**
     * 
     * @return
     *     The songname
     */
    public Songname getSongname() {
        return songname;
    }

    /**
     * 
     * @param songname
     *     The songname
     */
    public void setSongname(Songname songname) {
        this.songname = songname;
    }

    /**
     * 
     * @return
     *     The artistname
     */
    public Artistname getArtistname() {
        return artistname;
    }

    /**
     * 
     * @param artistname
     *     The artistname
     */
    public void setArtistname(Artistname artistname) {
        this.artistname = artistname;
    }

    /**
     * 
     * @return
     *     The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
