package model;

/**
 * Created by melkir on 04/03/15.
 */
public class Music {
    private static int autoincrement = 0;
    private final int id;
    private String genre, artist, album, titre, price, note;

    public Music() {
        id = ++autoincrement;
    }

    public Music(String genre, String artist, String album, String titre, String price, String note) {
        this.id = ++autoincrement;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.titre = titre;
        this.price = price;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitre() {
        return titre;
    }

    public String getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public String toString() {
        return id + ";" + genre + ";" + titre + ";" + artist + ";" + album + ";" + price + ";" + note;
    }

}
