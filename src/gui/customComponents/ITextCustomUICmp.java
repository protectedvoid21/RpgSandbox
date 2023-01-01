package gui.customComponents;

import gui.customUI.interfaces.ICustomUI;

public interface ITextCustomUICmp {
    ICustomUI getCustomUI();
    void setText(String newContent);
    int getMaximumPossibleFontSize();
    void setFont(int newFontSize);
    boolean hasSharedSize();
}
