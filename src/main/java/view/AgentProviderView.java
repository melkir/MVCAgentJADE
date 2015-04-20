package view;

import model.Music;
import module.MusicTree;
import org.gnome.gtk.ScrolledWindow;
import org.gnome.gtk.TextView;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentProviderView extends AbstractAgentView {
    private TextView textViewMusicSold;
    private MusicTree musicTree;

    public AgentProviderView() {
        super("AgentProvider.glade");
    }

    protected void initComposant() {
        super.initComposant();
        textViewMusicSold = (TextView) builder.getObject("music_sold");
        musicTree = new MusicTree();
        ScrolledWindow scrolledWindow = (ScrolledWindow) builder.getObject("scrolledwindow");
        scrolledWindow.add(musicTree);
    }

    public void addMusicAvailable(Music music) {
        musicTree.addMusic(music);
    }

    public void addMusicSoldToConsole(String music) {
        addMessageToConsole(textViewMusicSold, music);
    }

}
