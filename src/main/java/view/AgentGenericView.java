package view;

import org.gnome.gtk.Button;
import org.gnome.gtk.Entry;
import org.gnome.gtk.TextBuffer;
import org.gnome.gtk.TextView;

/**
 * Created by melkir on 05/03/15.
 */
public abstract class AgentGenericView extends AbstractView {

    Entry entryArtist, entryAlbum, entryName, entryPrice; // entrySearchMusic;
    Button buttonAdd;

    public AgentGenericView(String filepath) {
        super(filepath);
    }

    @Override
    protected void initComposant() {
        entryArtist = (Entry) builder.getObject("entry_artist");
        entryAlbum = (Entry) builder.getObject("entry_album");
        entryName = (Entry) builder.getObject("entry_name");
        entryPrice = (Entry) builder.getObject("entry_price");
        buttonAdd = (Button) builder.getObject("button_submit");
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


    public void addButtonAddClickedListener(Button.Clicked listener) {
        buttonAdd.connect(listener);
    }

    public void addMessageToConsole(TextView textView, String message) {
        TextBuffer textBuffer = textView.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), message + '\n');
    }

}
