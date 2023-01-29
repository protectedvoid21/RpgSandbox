package gui.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class WarhammerBundle extends CustomBundle {
    public WarhammerBundle(Locale locale) {
        super(locale);
    }

    @Override
    protected CustomBundle generateClassInstance(Locale locale) {
        return this;
    }

    @Override
    protected ResourceBundle generateSpecificInstance(Locale locale, ClassLoader loader) {
        return ResourceBundle.getBundle("WarhammerBundle", locale, loader);
    }
}
