package src.test;

import src.main.Practice.LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        System.out.println("LRUCacheTest...");
        LRUCache lruCache = new LRUCache(4);
        lruCache.putKey(2, 6);
        lruCache.putKey(4, 7);
        lruCache.putKey(8, 11);
        lruCache.putKey(7, 10);
        System.out.println(lruCache.getKey(2));
        System.out.println(lruCache.getKey(8));
        lruCache.putKey(5, 6);
        lruCache.putKey(10, 6);
        lruCache.putKey(11, 9);
        System.out.println(lruCache.getKey(7));
        lruCache.putKey(5, 7);
    }
}
