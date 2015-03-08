package view;

import model.MusicTreeModel;
import org.gnome.gtk.*;

/**
 * Created by melkir on 06/03/15.
 */
public class MusicTreeView {
    final TreeView view;
    CellRendererText renderer;

    public MusicTreeView(MusicTreeModel model) {
        view = new TreeView(model.getListStore());
        TreeViewColumn vertical;

        vertical = view.appendColumn();
        vertical.setTitle("Titre");
        renderer = new CellRendererText(vertical);
        renderer.setText(model.getColumnTitle());
        vertical.setExpand(true);

        vertical = view.appendColumn();
        vertical.setTitle("Artiste");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(model.getColumnArtist());
        vertical.setExpand(true);

        vertical = view.appendColumn();
        vertical.setTitle("Album");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(model.getColumnAlbum());
        vertical.setExpand(true);

        vertical = view.appendColumn();
        vertical.setTitle("Genre");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(model.getColumnAlbum());
        vertical.setExpand(true);

        vertical = view.appendColumn();
        vertical.setTitle("Prix");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(model.getColumnPrice());
        vertical.setExpand(true);

        vertical = view.appendColumn();
        vertical.setTitle("Note");
        renderer = new CellRendererText(vertical);
        renderer.setAlignment(0.0f, 0.0f);
        renderer.setText(model.getColumnNote());
        vertical.setExpand(true);
    }

    public TreeView getTreeView() {
        return view;
    }

}
