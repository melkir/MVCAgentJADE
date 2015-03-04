import controller.PlatformManagerController;
import model.PlatformManager;
import org.gnome.gtk.Gtk;
import view.PlatformManagerView;

/**
 * Created by melkir on 02/03/15.
 */
public class MVCAgent {

    public static void main(String[] args) {
        Gtk.init(args);
        PlatformManager model = new PlatformManager();
        PlatformManagerView view = new PlatformManagerView();
        PlatformManagerController controller = new PlatformManagerController(model, view);
        view.setVisible(true);
        Gtk.main();
    }
}
