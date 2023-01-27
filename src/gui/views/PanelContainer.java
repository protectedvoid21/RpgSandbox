package gui.views;

import gui.menu.ComponentPanelMenager;

import javax.swing.*;

public interface PanelContainer {
    ComponentPanelMenager<? extends JComponent> getPanel();

}
