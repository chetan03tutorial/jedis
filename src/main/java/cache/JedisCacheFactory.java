package cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jedis.JedisConnectionPool;
import jedis.config.CacheConnectionPoolConfiguration;
import redis.clients.jedis.Jedis;

public class JedisCacheFactory  {

    private JedisCacheFactory() {
	
    }

    public static Jedis getCache() {
	Map<String, String> configValues = new HashMap<>();
	CacheConnectionPoolConfiguration cachePoolConfiguration = new CacheConnectionPoolConfiguration(configValues);
	JedisConnectionPool connectionFactory = JedisConnectionPool.getInstance(cachePoolConfiguration);
	Jedis jedis = connectionFactory.getConnection();
	return jedis;
    }
    
    
}
