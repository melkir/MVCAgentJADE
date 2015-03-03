package view;

import org.gnome.gdk.Event;
import org.gnome.gtk.*;
import org.gnome.gtk.Button.Clicked;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManagerView extends AbstractView {
    Window mainWindow;
    Entry entryName;
    RadioButton radioProvider, radioSeeker;
    TextView textViewResult;
    Button buttonAdd;

    public PlatformManagerView() {
        super("PlatformManager.glade");
        mainWindow.connect(new Window.DeleteEvent() {
            @Override
            public boolean onDeleteEvent(Widget widget, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });
    }

    protected void initComposant() {
        mainWindow = (Window) builder.getObject("mainWindow");
        entryName = (Entry) builder.getObject("entry_name");
        radioProvider = (RadioButton) builder.getObject("radiobutton_provider");
        radioSeeker = (RadioButton) builder.getObject("radiobutton_seeker");
        buttonAdd = (Button) builder.getObject("button_add");
        textViewResult = (TextView) builder.getObject("textview_result");
    }

    public String getAgentName() {
        return entryName.getText();
    }

    public String getAgentType() {
        if (radioProvider.getActive()) return "provider";
        else if (radioSeeker.getActive()) return "seeker";
        else return "unknown";
    }

    /**
     * Add agent to the result view panel
     */
    public void addAgentToView(String agent) {
        TextBuffer textBuffer = textViewResult.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), agent + '\n');
    }

    public void addEntryActivateListener(Entry.Activate listener) {
        entryName.connect(listener);
    }

    public void addButtonAddClickedListener(Clicked listener) {
        buttonAdd.connect(listener);
    }

    public void displayErrorMessage(String errorMsg) {
        final MessageDialog messageDialog = new MessageDialog(mainWindow, true, MessageType.ERROR, ButtonsType.CLOSE, errorMsg);
        if (messageDialog.run() == ResponseType.CLOSE) messageDialog.destroy();
    }

    public void setVisible(boolean visible) {
        if (visible) mainWindow.show();
        else mainWindow.hide();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
