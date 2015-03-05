package view;

import org.gnome.gtk.Builder;
import org.gnome.gtk.Window;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class AbstractView implements Observer {

    protected final Builder builder;
    protected final Window window;

    public AbstractView(String filepath) {
        this.builder = new Builder();
        try {
            builder.addFromFile("resources/" + filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        window = (Window) builder.getObject("mainWindow");
        initComposant();
    }

    protected abstract void initComposant();

    public void addWindowCloseEvent(Window.DeleteEvent event) {
        window.connect(event);
    }

    public void setTitle(String title) {
        window.setTitle(title);
    }

    public void setVisible(boolean visible) {
        if (visible) window.show();
        else window.hide();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
