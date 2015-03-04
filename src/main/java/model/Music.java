package model;

/**
 * Created by melkir on 04/03/15.
 */
public class Music {
    String genre, artist, album, name, price, note;

    public Music(String genre, String artist, String album, String name, String price, String note) {
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.price = price;
        this.note = note;
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
        return genre + "," + artist + "," + name + "," + price + "," + note;
    }

}
