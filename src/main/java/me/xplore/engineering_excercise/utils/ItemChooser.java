package me.xplore.engineering_excercise.utils;

import me.xplore.engineering_excercise.types.WheelItem;

import java.util.ArrayList;
import java.util.Random;

public class ItemChooser {
    public static WheelItem chooseItem(ArrayList<WheelItem> items) {
        int totalChance = 100;
        int randomNumber = new Random().nextInt(totalChance) + 1;
        int currentChance = 0;
        for (WheelItem item : items) {
            currentChance += item.chance;
            if (randomNumber <= currentChance) {
                return item;
            }
        }
        return null;
    }
}
