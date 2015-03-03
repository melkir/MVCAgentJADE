package view;

import org.gnome.gtk.Builder;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Observer;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class AbstractView implements Observer {

    protected final Builder builder;

    public AbstractView(String filepath) {
        this.builder = new Builder();
        try {
            builder.addFromFile("resources/" + filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        initComposant();
    }

    protected abstract void initComposant();

    public abstract void setVisible(boolean visible);

}
