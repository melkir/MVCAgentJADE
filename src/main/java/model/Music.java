package model;

/**
 * Created by melkir on 04/03/15.
 */
public class Music {
    private String genre;
    private String artist;
    private String album;
    private String name;
    private String price;
    private String note;

    public Music(String genre, String artist, String album, String name, String price, String note) {
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        return genre + "," + artist + "," + album + "," + name + "," + price + "," + note;
    }

}
