package cachetest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CacheManager {
    private Map<String,Object> cache = new ConcurrentHashMap<>();

    public Object getValue(String key){
        return cache.get(key);
    }
    public void addOrUpdate(String key, Object value){
        cache.put(key, value);
    }
    public void evictCache(String key){
        if (cache.containsKey(key))
            cache.remove(key);
    }
    public void evictCache(){
        cache.clear();
    }

}
