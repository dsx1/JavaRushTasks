package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.sun.prism.impl.shape.ShapeRasterizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startTime = new Date();
        for (String str : strings){
            ids.add(shortener.getId(str));
        }
        Date endTime = new Date();
        long delta = endTime.getTime() - startTime.getTime();
        return delta;
    }
    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTime = new Date();
        for (Long id : ids){
            strings.add(shortener.getString(id));
        }
        Date endTime = new Date();
        long delta = endTime.getTime() - startTime.getTime();
        return delta;
    }

    @Test
    public void testHashMapStorage(){
        HashMapStorageStrategy strategy1 = new HashMapStorageStrategy();
        HashBiMapStorageStrategy strategy2 = new HashBiMapStorageStrategy();
        Shortener shortener1 = new Shortener(strategy1);
        Shortener shortener2 = new Shortener(strategy2);
        HashSet<String> origStrings = new HashSet<>(10000);
        for (int i=0;i<origStrings.size();i++){
            origStrings.add(Helper.generateRandomString());
        }
        HashSet<Long> ids = new HashSet<>(10000);
        long time1 = getTimeForGettingIds(shortener1,origStrings,ids);
        ids.clear();
        long time2 = getTimeForGettingIds(shortener2,origStrings,ids);
        Assert.assertEquals(time2,time1,30);
        origStrings.clear();
        long time3 = getTimeForGettingStrings(shortener1,ids,origStrings);
        origStrings.clear();
        long time4 = getTimeForGettingStrings(shortener2,ids,origStrings);
        Assert.assertEquals(time4,time3,30);
    }
}
