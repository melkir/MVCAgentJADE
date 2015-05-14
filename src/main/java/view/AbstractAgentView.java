package view;

import org.gnome.gtk.*;

/**
 * Created by melkir on 05/03/15.
 */
public abstract class AbstractAgentView extends AbstractView {

    private Entry entryArtist, entryAlbum, entryName, entryPrice; // entrySearchMusic;
    private Button buttonAdd;
    private ComboBoxText comboGenre;
    private RadioGroup radioGroupStars;

    AbstractAgentView(String filepath) {
        super(filepath);
    }

    @Override
    protected void initComposant() {
        createComboBoxGenre();
        createRadioGroupStars();
        entryArtist = (Entry) builder.getObject("entry_artist");
        entryAlbum = (Entry) builder.getObject("entry_album");
        entryName = (Entry) builder.getObject("entry_name");
        entryPrice = (Entry) builder.getObject("entry_price");
        buttonAdd = (Button) builder.getObject("button_submit");
    }

    private void createRadioGroupStars() {
        Box box = (Box) builder.getObject("box_stars");
        radioGroupStars = new RadioGroup();
        for (int i = 1; i < 6; i++) box.add(new RadioButton(radioGroupStars, Integer.toString(i)));
    }

    private void createComboBoxGenre() {
        Grid grid = (Grid) builder.getObject("grid_fields");
        this.comboGenre = new ComboBoxText();
        String[] listGenre = {"JAZZ", "ROCK", "METAL", "DISCO"};
        for (String genre : listGenre) this.comboGenre.appendText(genre);
        this.comboGenre.setActive(0);
        grid.attach(comboGenre, 1, 0, 1, 1);
    }

    public String getNote() {
        return ((RadioButton) radioGroupStars.getActive()).getLabel();
    }

    public String getGenre() {
        return comboGenre.getActiveText();
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

    void addMessageToConsole(TextView textView, String message) {
        TextBuffer textBuffer = textView.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), message + '\n');
    }

}
