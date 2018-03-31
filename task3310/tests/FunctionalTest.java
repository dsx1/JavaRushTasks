package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener){
        String str1 = "someString";
        String str2 = "another String";
        String str3 = "someString";
        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);
        Assert.assertNotEquals(id2,id1);
        Assert.assertNotEquals(id2,id3);
        Assert.assertEquals(id3,id1);
        String newStr1 = shortener.getString(id1);
        String newStr2 = shortener.getString(id2);
        String newStr3 = shortener.getString(id3);
        Assert.assertEquals(newStr1,str1);
        Assert.assertEquals(newStr2,str2);
        Assert.assertEquals(newStr3,str3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
