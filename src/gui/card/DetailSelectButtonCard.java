package gui.card;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetailSelectButtonCard extends NormalDetailButtonsCard {
    protected ArrayList<AbstractCustomButton> selectList;
    private int selectedIndex = -1;


    public DetailSelectButtonCard(GuiFactory factory) {
        super(factory);
        selectedIndex = 6;
    }

//    @Override
//    protected ArrayList<? extends IContentCustomUICmp> getContentList() {
//        return selectList;
//    }


    public AbstractCustomButton getSelectButton(int index) {
        return selectList.get(index);
    }

    public void setSelectedIndex(int value){
        selectedIndex = value;
    }


    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;
        for (var key : sublist) {
            String content = "SELECT";
            var but =  selectList.get(currentIndex);
            if (currentAttrSide*maximumElementNumber+currentIndex==selectedIndex){
                content = "SELECTED";
                but.setEnabled(false);
            }else{
                if (!but.isEnabled()){
                    but.setEnabled(true);
                }
            }
            selectList.get(currentIndex).setContent(content);
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                System.out.println("ustatwiam pusge");
                selectList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }
        Card.setAspectVisible(selectList, true);
        System.out.println(selectList);
    }

    @Override
    protected void initializeContent() {

        super.initializeContent();
        selectList = new ArrayList<>();
        for (int i = 0; i < maximumElementNumber; i++) {
            initButton(selectList, "SELECT");
        }

    }


    @Override
    protected void initializeCard(int maximumElementNumber) {
        super.initializeCard(maximumElementNumber);
        getContentMenager().addMainComponent(10);

    }

    @Override
    public void setUniformForm() {
        super.setUniformForm();
        SharedCmpsFont.setUniformFont(selectList);
    }

}