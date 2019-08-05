package jedis;

import jedis.config.CacheConnectionPoolConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisConnectionPool {

    private static volatile JedisConnectionPool _instance;
    private JedisPool jedisPool;

    private JedisConnectionPool(CacheConnectionPoolConfiguration configuration) {
	jedisPool = new JedisPool(configuration, configuration.getHost(), configuration.getPort(),
		Protocol.DEFAULT_TIMEOUT, null, false);
    }

    public static JedisConnectionPool getInstance(CacheConnectionPoolConfiguration configuration) {
	if (_instance == null) {
	    synchronized (JedisConnectionPool.class) {
		if (_instance == null) {
		    _instance = new JedisConnectionPool(configuration);
		}
	    }
	}
	return _instance;
    }

    public Jedis getConnection() {
	Jedis connection = null;
	if (isAvailable()) {
	    connection = jedisPool.getResource();
	}
	return connection;
    }

    public boolean isAvailable() {
	boolean isBroken = false;
	try {
	    Jedis jedis = jedisPool.getResource();
	    if (!jedis.isConnected()) {
		isBroken = true;
	    }
	} catch (JedisConnectionException ex) {
	    isBroken = true;
	}
	return !isBroken;
    }

}
