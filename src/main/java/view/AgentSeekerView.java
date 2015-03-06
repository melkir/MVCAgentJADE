package view;

import org.gnome.gtk.Entry;
import org.gnome.gtk.TextBuffer;
import org.gnome.gtk.TextView;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentSeekerView extends AbstractAgentView {
    // RadioGroup radioGroupNote;
    Entry entryNbMusic, entryMaxBudget;
    TextView textViewMusicFound;

    public AgentSeekerView() {
        super("AgentSeeker.glade");
    }

    protected void initComposant() {
        super.initComposant();
        // radioGroupNote = ((RadioButton) builder.getObject("1starts")).getGroup();    // Bug
        textViewMusicFound = (TextView) builder.getObject("music_found");
        entryNbMusic = (Entry) builder.getObject("entry_nbMusic");
        entryMaxBudget = (Entry) builder.getObject("entry_budget");
    }

    public void addMusicPurchasedToConsole(String music) {
        TextBuffer textBuffer = textViewMusicFound.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), music + '\n');
    }

}
