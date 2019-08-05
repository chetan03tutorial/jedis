package jedis;

import java.util.HashMap;
import java.util.Map;

import jedis.config.CacheConnectionPoolConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisConnectionPoolManager{

    protected JedisConnectionPool jedisConnectionPool;

    protected JedisConnectionPoolManager() {
    }
    
    protected JedisConnectionPoolManager(String host, Integer port) {
	Map<String, String> configValues = new HashMap<>();
	CacheConnectionPoolConfiguration cachePoolConfiguration = new CacheConnectionPoolConfiguration(configValues);
	cachePoolConfiguration.setHost(host);
	cachePoolConfiguration.setPort(port);
	jedisConnectionPool = JedisConnectionPool.getInstance(cachePoolConfiguration);
    }

    

    

    
    
    //abstract public ApplicationCache getCache();
    
    
    /*
     * public static CacheConnectionPool getInstance(String host, Integer port) { if
     * (cacheConnectionPool == null) { synchronized (CacheConnectionPool.class) { if
     * (cacheConnectionPool == null) { cacheConnectionPool = new
     * CacheConnectionPool(host, port); } } } return cacheConnectionPool; }
     */

    // private static volatile CacheConnectionPool cacheConnectionPool;
    
}
