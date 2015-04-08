package model;

/**
 * Created by melkir on 04/03/15.
 */
public class Music {
    private String genre, artist, album, titre, price, note;

    public Music(String genre, String artist, String album, String titre, String price, String note) {
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.titre = titre;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String name) {
        this.titre = name;
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
        return genre + "," + titre + "," + artist + "," + album + "," + price + "," + note;
    }

    public String[] toStringTab() {
        return new String[]{genre, artist, album, titre, price, note};
    }

}
