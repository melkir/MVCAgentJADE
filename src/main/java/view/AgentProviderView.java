package view;

import org.gnome.gtk.TextView;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentProviderView extends AbstractAgentView {
    // RadioGroup radioGroupNote;
    TextView textViewMusicAvailable, textViewMusicSold;

    public AgentProviderView() {
        super("AgentProvider.glade");
    }

    protected void initComposant() {
        super.initComposant();
        // entrySearchMusic = (Entry) builder.getObject("search_music");                // Not implemented
        // radioGroupNote = ((RadioButton) builder.getObject("1starts")).getGroup();    // Bug
        textViewMusicAvailable = (TextView) builder.getObject("music_available");
        textViewMusicSold = (TextView) builder.getObject("music_sold");
    }

    public void addMusicSoldToConsole(String music) {
        addMessageToConsole(textViewMusicSold, music);
    }

    public void addMusicAvailableToConsole(String music) {
        addMessageToConsole(textViewMusicAvailable, music);
    }

}
