package view;

import org.gnome.gtk.*;

import java.util.Observable;

/**
 * Created by melkir on 03/03/15.
 */
public class AgentSeekerView extends AbstractView {
    // ComboBoxText comboBoxTextGenre;
    // RadioGroup radioGroupNote;
    Window mainWindow;
    Entry entryArtist, entryAlbum, entryName, entryMaxPrice, entryNbMusic, entryMaxBudget;
    TextView textViewMusicFound;
    Button buttonAdd;

    public AgentSeekerView() {
        super("AgentSeeker.glade");
    }

    protected void initComposant() {
        // comboBoxTextGenre = (ComboBoxText) builder.getObject("comboboxtext_genre");  // Bug
        // radioGroupNote = ((RadioButton) builder.getObject("1starts")).getGroup();    // Bug
        mainWindow = (Window) builder.getObject("mainWindow");
        textViewMusicFound = (TextView) builder.getObject("music_found");
        entryArtist = (Entry) builder.getObject("entry_artist");
        entryAlbum = (Entry) builder.getObject("entry_album");
        entryName = (Entry) builder.getObject("entry_name");
        entryMaxPrice = (Entry) builder.getObject("entry_maxPrice");
        entryNbMusic = (Entry) builder.getObject("entry_nbMusic");
        entryMaxBudget = (Entry) builder.getObject("entry_budget");
        buttonAdd = (Button) builder.getObject("button_submit");
    }

    public void setTitle(String title) {
        mainWindow.setTitle(title);
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) mainWindow.show();
        else mainWindow.hide();
    }

    public void addMusicToConsole(String music) {
        TextBuffer textBuffer = textViewMusicFound.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), music + '\n');
    }

    public void addButtonAddClickedListener(Button.Clicked listener) {
        buttonAdd.connect(listener);
    }

    public void addWindowCloseEvent(Window.DeleteEvent event) {
        mainWindow.connect(event);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
