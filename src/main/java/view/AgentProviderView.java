package view;

import model.MusicTreeModel;
import org.gnome.gtk.ScrolledWindow;
import org.gnome.gtk.TextView;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentProviderView extends AbstractAgentView {
    TextView textViewMusicSold;

    public AgentProviderView() {
        super("AgentProvider.glade");
    }

    protected void initComposant() {
        super.initComposant();
        textViewMusicSold = (TextView) builder.getObject("music_sold");
    }

    public void attachMusicTreeModel(MusicTreeModel model) {
        ScrolledWindow scrolledWindow = (ScrolledWindow) builder.getObject("scrolledwindow");
        scrolledWindow.add(new MusicTreeView(model).getTreeView());
    }

    public void addMusicSoldToConsole(String music) {
        addMessageToConsole(textViewMusicSold, music);
    }

}
