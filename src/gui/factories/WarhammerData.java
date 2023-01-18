package gui.factories;

import gui.utils.StringAdapter;

import java.awt.*;

public interface WarhammerData {
    String moveOption = StringAdapter.getRelativePath("movingOpt.png");
    String cardOption = StringAdapter.getRelativePath("cardOpt.png");
    String carefullattackOpt = StringAdapter.getRelativePath("swordsOpt.png");
    String normalAttackOpt = StringAdapter.getRelativePath("attackOpt.png");
    String fastAttactOpt = StringAdapter.getRelativePath("knivesOpt.png");
    String defenseStandOpt = StringAdapter.getRelativePath("shieldOpt.png");
    String targetOpt = StringAdapter.getRelativePath("targetOpt.png");
    String blockOption = StringAdapter.getRelativePath("block.png");
    String fontPath = StringAdapter.getRelativePath("Sabatica-regular.ttf");
    String background1 = StringAdapter.getRelativePath("aveeee.jpg");
    String editPath = StringAdapter.getRelativePath("edit.png");
    String createPath = StringAdapter.getRelativePath("create.png");
    String viewPath = StringAdapter.getRelativePath("view.png");
    String horsePath =StringAdapter.getRelativePath("horse");
    String efectPath = StringAdapter.getRelativePath("effect.png");
    String armorPath = StringAdapter.getRelativePath("armor.png");
    String weaponPath = StringAdapter.getRelativePath("weapon.png");
    String trolleyPath =StringAdapter.getRelativePath("trolley.png");
    String monsterPath = StringAdapter.getRelativePath("monsterimage.png");
    String playerImagePath =StringAdapter.getRelativePath("playerimage.png");
    String npcImage = StringAdapter.getRelativePath("npcimage.png");
    String plusImage = StringAdapter.getRelativePath("plus.png");
    String cardBackground = StringAdapter.getRelativePath("cardbackground.jpg");
    String avePath =StringAdapter.getRelativePath("ave.jpg");
    Color basicBorderColor = new Color(0x4D0202);//jako ze wszedzie ten sam to moze sie popsuc gdy gdzies sie
    // przypadkiem zmieni, brak czasu na testy, sie w miedzyczasie to ogarnie
    int basicBorderSize = 10;

}
