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

public class DetailButtonsCard extends AbstractCard<JComponent> {
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();
//    protected ArrayList<AbstractCustomButton> selectList = new ArrayList<>();
    protected ArrayList<AbstractCustomButton> detailList = new ArrayList<>();


    /**
     * dataMap should be in format [[path1, text1], [path2, text2], [path3, text3]...]
     */
    public DetailButtonsCard(GuiFactory factory) {
        super(factory);
        initializeCard(3);
        initializeContent();
    }

    public AbstractCustomButton getDetailButton(int index){
        return detailList.get(index);
    }


    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return menager;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.content.size();
        var sublist = data.content.subList(currentAttrSide * maximumElementNumber, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);
        int currentIndex = 0;
        for (var key : sublist) {
            for (int i = 0; i < 2; i++) {
                labelList.get(2 * currentIndex + i).setContent(key.get(i));
            }
            detailList.get(currentIndex).setContent("DETAILS");
//            selectList.get(currentIndex).setContent("SELECT");
            currentIndex++;
        }
        if (sublist.size() < maximumElementNumber) {
            for (int i = dataSize % maximumElementNumber; i < maximumElementNumber; i++) {
                for (int j = 0; j < 2; j++) {
                    labelList.get(2 * i + j).setContent(Card.EMPTY_DATA_CONTENT);
                }
                detailList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
//                selectList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
            }
        }
        for (var list : Arrays.asList(labelList, detailList)) {
            Card.setAspectVisible(list, true);
        }
    }

    @Override
    protected void initializeContent() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        for (int i = 0; i < maximumElementNumber; i++) {
            initLabel(GuiFactory.LabelType.ICON);
            initLabel(GuiFactory.LabelType.NORMAL);
            initButton(detailList, "DETAIL");
//            initButton(selectList, "SELECT");
        }

    }

    protected void initLabel(GuiFactory.LabelType type) {
        factory.setLabelType(type);
        var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        int index = type == GuiFactory.LabelType.NORMAL ? 1 : 0;
        menager.addMiddleComponent(label, index, 20);
        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(2);
        labelList.add(label);
    }

    protected void initButton(ArrayList list, String text) {
        var button = factory.createButton(text, null);
        int index = list == detailList ? 2 : 3;
        menager.addMiddleComponent(button, index, 20);
        menager.getMainComponent(index).getComponent().getLastComponent().addSpace(4);
        list.add(button);
    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        menager.addMainComponent(15);
        menager.addMainComponent(15);
        menager.addMainComponent(10);
//        menager.addMainComponent(10);

        super.initializeCard(maximumElementNumber);
    }

    @Override
    public void setUniformForm() {
        SharedCmpsFont.setUniformFont(detailList);
        SharedCmpsFont.setUniformFont(labelList);
    }

}
