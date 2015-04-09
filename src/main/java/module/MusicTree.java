package module;

import model.Music;
import org.gnome.gtk.*;

/**
 * Created by melkir on 10/03/15.
 */
public class MusicTree extends TreeView {
    ListStore model;
    DataColumnString title, artist, album, genre, price, note;
    CellRendererText renderer;
    TreeIter row;

    public MusicTree() {
        model = new ListStore(new DataColumn[]{
                title = new DataColumnString(),
                artist = new DataColumnString(),
                album = new DataColumnString(),
                genre = new DataColumnString(),
                price = new DataColumnString(),
                note = new DataColumnString()
        });

        this.setModel(model);
        TreeViewColumn vertical;

        vertical = this.appendColumn();
        vertical.setTitle("Titre");
        renderer = new CellRendererText(vertical);
        renderer.setText(title);
        vertical.setSortColumn(title);
        vertical.setExpand(true);

        vertical = this.appendColumn();
        vertical.setTitle("Artiste");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(artist);
        vertical.setSortColumn(artist);
        vertical.setExpand(true);

        vertical = this.appendColumn();
        vertical.setTitle("Album");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(album);
        vertical.setSortColumn(album);
        vertical.setExpand(true);

        vertical = this.appendColumn();
        vertical.setTitle("Genre");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(genre);
        vertical.setSortColumn(genre);

        vertical = this.appendColumn();
        vertical.setTitle("Prix");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(price);
        vertical.setSortColumn(price);

        vertical = this.appendColumn();
        vertical.setTitle("Note");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(note);
        vertical.setSortColumn(note);
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

    private void testData() {
        Music music1 = new Music("Genre", "Artist", "Album", "Titre", "10", "3");
        Music music2 = new Music("Genre1", "Artist1", "Album1", "Titre1", "20", "2");
        addMusic(music1);
        addMusic(music2);
    }

}
