package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String str : strings){
            ids.add(shortener.getId(str));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long id : keys){
            strings.add(shortener.getString(id));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i=0;i<elementsNumber;i++){
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDateTime = new Date();

        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        Date date1 = new Date();
        Set<String> strs = getStrings(shortener,ids);
        Date date2 = new Date();

        long delta = date2.getTime() - date1.getTime();
        Helper.printMessage(Long.toString(delta));
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
