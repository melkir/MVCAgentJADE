package view;

import org.gnome.gdk.Event;
import org.gnome.gtk.*;
import org.gnome.gtk.Button.Clicked;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManagerView extends AbstractView {
    private RadioButton radioProvider;
    private RadioButton radioSeeker;
    private TextView textViewResult;
    private Button buttonAdd;

    public PlatformManagerView() {
        super("PlatformManager.glade");
        window.connect(new Window.DeleteEvent() {
            public boolean onDeleteEvent(Widget widget, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });
    }

    protected void initComposant() {
        radioProvider = (RadioButton) builder.getObject("radiobutton_provider");
        radioSeeker = (RadioButton) builder.getObject("radiobutton_seeker");
        buttonAdd = (Button) builder.getObject("button_add");
        textViewResult = (TextView) builder.getObject("textview_result");
    }

    /**
     * Return the type selected for the agent
     *
     * @return String type
     */
    public String getAgentType() {
        if (radioProvider.getActive()) return "provider";
        else if (radioSeeker.getActive()) return "seeker";
        else return "unknown";
    }

    /**
     * Add agent to the result view panel
     */
    public void addAgentToConsole(String agent) {
        TextBuffer textBuffer = textViewResult.getBuffer();
        textBuffer.insert(textBuffer.getIterEnd(), agent + '\n');
    }

    public void addButtonAddClickedListener(Clicked listener) {
        buttonAdd.connect(listener);
    }

    public void displayErrorMessage(String errorMsg) {
        final MessageDialog messageDialog = new MessageDialog(window, true, MessageType.ERROR, ButtonsType.CLOSE, errorMsg);
        if (messageDialog.run() == ResponseType.CLOSE) messageDialog.destroy();
    }

}
