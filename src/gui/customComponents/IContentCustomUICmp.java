package gui.customComponents;

import gui.customUI.interfaces.ICustomUI;

public interface IContentCustomUICmp {
    ICustomUI getCustomUI();
    String getContent();
    void setContent(String newContent);
    int getMaximumPossibleFontSize();
    void setFont(int newFontSize);
    boolean hasSharedSize();
}
