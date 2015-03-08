package model;

import org.gnome.gtk.DataColumn;
import org.gnome.gtk.DataColumnString;
import org.gnome.gtk.ListStore;
import org.gnome.gtk.TreeIter;

/**
 * Created by melkir on 06/03/15.
 */
public class MusicTreeModel {
    final ListStore model;
    final DataColumnString title, artist, album, genre, price, note;
    TreeIter row;

    public MusicTreeModel() {
        model = new ListStore(new DataColumn[]{
                title = new DataColumnString(),
                artist = new DataColumnString(),
                album = new DataColumnString(),
                genre = new DataColumnString(),
                price = new DataColumnString(),
                note = new DataColumnString(),
        });
        // Data test
        insertTestData();
    }

    public void addMusic(Music music) {
        row = model.appendRow();
        model.setValue(row, title, music.getTitre());
        model.setValue(row, artist, music.getArtist());
        model.setValue(row, album, music.getAlbum());
        model.setValue(row, genre, music.getGenre());
        model.setValue(row, price, music.getPrice());
        model.setValue(row, note, music.getNote());
    }

    public DataColumnString getColumnTitle() {
        return title;
    }

    public DataColumnString getColumnArtist() {
        return artist;
    }

    public DataColumnString getColumnAlbum() {
        return album;
    }

    public DataColumnString getColumnGenre() {
        return genre;
    }

    public DataColumnString getColumnPrice() {
        return price;
    }

    public DataColumnString getColumnNote() {
        return note;
    }

    private void insertTestData() {
        Music music1 = new Music("Genre", "Artist", "Album", "Titre", "10", "3");
        Music music2 = new Music("Genre1", "Artist1", "Album1", "Titre1", "20", "2");
        addMusic(music1);
        addMusic(music2);
    }

    public ListStore getListStore() {
        return model;
    }

}
