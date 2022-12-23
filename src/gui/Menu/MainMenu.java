package gui.Menu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JPanel restPanel;
    private JPanel titlePanel;
    private  GridBagConstraints restCst;
    private  GridBagConstraints mainCst;
    private GridBagLayout restLayout;
    private int componentsNumber = 0;

    public MainMenu() {
        super();
        titlePanel = new JPanel();
        var layout = new BorderLayout();
        titlePanel.setLayout(layout);

        restCst = new GridBagConstraints();
        restPanel = new JPanel();
        restLayout = new GridBagLayout();
        restPanel.setLayout(restLayout);

        mainCst = new GridBagConstraints();
        var mainLayout = new GridBagLayout();
        setLayout(mainLayout);


        mainCst.fill = GridBagConstraints.BOTH;
        mainCst.gridx = 1;
        mainCst.gridy = 2;
        mainCst.weighty = 7;
        mainCst.weightx = 2;
        add(restPanel, mainCst);


        restCst.fill = GridBagConstraints.BOTH;
        restCst.weightx = 2;
    }

    public MainMenu(Container parent){
        this();
        parent.add(this);
    }

    private void initializeTitlePanel(){
        mainCst.gridy = 1;
        mainCst.weighty = 3;
        mainCst.fill = GridBagConstraints.HORIZONTAL;
        add(titlePanel, mainCst);
    }
    public void setTitle(Component component){
        if (titlePanel.getComponents().length>0){
            titlePanel.remove(0);
        }else{
            initializeTitlePanel();
        }
        titlePanel.add(component);
    }

    private void addElementToRestPanel(Component component,int gridy, int weighty){
        restCst.gridy = gridy;
        restCst.weighty = weighty;
        restPanel.add(component, restCst);
    }
    private void addEmptyElementToRestPanel(int gridy){
        addElementToRestPanel(Box.createVerticalBox(), gridy, 20);
    }
    private void addComponentToRestPanel(Component component){
        addElementToRestPanel(component, componentsNumber*3+1, 30);
    }
    public void addOption(Component component) {
        restCst.gridx = 1;
        addEmptyElementToRestPanel(componentsNumber*3);
        addComponentToRestPanel(component);
        addEmptyElementToRestPanel(componentsNumber*3+2);
        componentsNumber++;
    }

    public void increaseSize(int index, double ratio){
        int currentIndex = index*3+1;
        var cmpnt =  restPanel.getComponent(currentIndex);
        var constraint = restLayout.getConstraints(cmpnt);
        constraint.weighty = restLayout.getConstraints(cmpnt).weighty*ratio;
        restLayout.setConstraints(cmpnt, constraint);
        restPanel.revalidate();
        restPanel.repaint();
    }

    public void increseTitleSize(){
        //todo
    }

    private void addVerticalPanelHelper(GridBagConstraints constraints, JPanel panel){
        constraints.weightx = 1;

        constraints.gridx = 0;
        panel.add(Box.createVerticalBox(), constraints);

        constraints.gridx = 2;
        panel.add(Box.createVerticalBox(), constraints);
    }


    public void addMiddlePartVerticalPanels(){
        addVerticalPanelHelper(restCst, restPanel);
    }

    public void addVerticalPanels() {
        addVerticalPanelHelper(mainCst, this);
    }
    public void addHorizontalPanels() {
        mainCst.weighty = 1;

        mainCst.gridy = 0;
        add(Box.createHorizontalBox(), mainCst);

        mainCst.gridy = 3;
        add(Box.createHorizontalBox(), mainCst);
    }



}
