package view;

import org.gnome.gtk.*;

import java.util.Observable;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentProviderView extends AbstractView {
    // ComboBoxText comboBoxTextGenre;
    // RadioGroup radioGroupNote;
    Window mainWindow;
    Entry entryArtist, entryAlbum, entryName, entryPrice; // entrySearchMusic;
    TextView textViewMusicAvailable, textViewMusicSold;
    Button buttonAdd;

    public AgentProviderView() {
        super("AgentProvider.glade");
    }

    protected void initComposant() {
        // entrySearchMusic = (Entry) builder.getObject("search_music");                // Not implemented
        // comboBoxTextGenre = (ComboBoxText) builder.getObject("comboboxtext_genre");  // Bug
        // radioGroupNote = ((RadioButton) builder.getObject("1starts")).getGroup();    // Bug
        mainWindow = (Window) builder.getObject("mainWindow");
        textViewMusicAvailable = (TextView) builder.getObject("music_available");
        entryArtist = (Entry) builder.getObject("entry_artist");
        entryAlbum = (Entry) builder.getObject("entry_album");
        entryName = (Entry) builder.getObject("entry_name");
        entryPrice = (Entry) builder.getObject("entry_price");
        buttonAdd = (Button) builder.getObject("add_music");
        textViewMusicSold = (TextView) builder.getObject("music_sold");
    }

    public String getArtist() {
        return entryArtist.getText();
    }

    public String getAlbum() {
        return entryAlbum.getText();
    }

    public String getName() {
        return entryName.getText();
    }

    public String getPrice() {
        return entryPrice.getText();
    }

    public void setTitle(String title) {
        mainWindow.setTitle(title);
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) mainWindow.show();
        else mainWindow.hide();
    }

    public void addButtonAddClickedListener(Button.Clicked listener) {
        buttonAdd.connect(listener);
    }

    public void addMusicSoldToConsole(String music) {
        TextBuffer textBuffer = textViewMusicSold.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), music + '\n');
    }

    public void addMusicAvailableToConsole(String music) {
        TextBuffer textBuffer = textViewMusicAvailable.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), music + '\n');
    }

    public void addWindowCloseEvent(Window.DeleteEvent event) {
        mainWindow.connect(event);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
