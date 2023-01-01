package gui.menu;

import javax.swing.*;

public class CustomMenuMenager extends DefaultCustomMenuMenager<JComponent>{
    public CustomMenuMenager(ComponentsSeries.ComponentsDimension mainSide,
                             ComponentsSeries.ComponentsDimension middleSide) {
        super(mainSide, middleSide);
    }

    public CustomMenuMenager(JPanel parent, ComponentsSeries.ComponentsDimension mainSide,
                             ComponentsSeries.ComponentsDimension middleSide) {
        super(parent, mainSide, middleSide);
    }
}
