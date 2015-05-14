package view;

import org.gnome.gtk.*;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentSeekerView extends AbstractAgentView {
    private Entry entryNbMusic;
    private Entry entryMaxBudget;
    private TextView textViewMusicFound;

    public AgentSeekerView() {
        super("AgentSeeker.glade");
    }

    protected void initComposant() {
        super.initComposant();
        textViewMusicFound = (TextView) builder.getObject("music_found");
        entryNbMusic = (Entry) builder.getObject("entry_nbMusic");
        entryMaxBudget = (Entry) builder.getObject("entry_budget");
    }

    public String getNbMusic() {
        return entryNbMusic.getText();
    }

    public String getBudget() {
        return entryMaxBudget.getText();
    }

    public void addMusicPurchasedToConsole(String music) {
        TextBuffer textBuffer = textViewMusicFound.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), music + '\n');
    }

    public void displayErrorMessage(String message) {
        final MessageDialog messageDialog = new MessageDialog(window, true, MessageType.ERROR, ButtonsType.CLOSE, message);
        if (messageDialog.run() == ResponseType.CLOSE) messageDialog.destroy();
    }
}
