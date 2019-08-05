package cache;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class ApplicationCache extends AbstractApplicationCacheContext implements AutoCloseable {

    public ApplicationCache(Jedis jedis) {
	super(jedis);
    }

    public void setStringPair(String key, String value) {
	try (Jedis connection = getJedis()) {
	    connection.set(key, value);
	}
    }

    public String getStringPair(String key) {
	try (Jedis connection = getJedis()) {
	    return connection.get(key);
	}

    }

    public void leftInsertInList(String listKey, String value) {
	try (Jedis connection = getJedis()) {
	    connection.lpush(listKey, value);
	}

    }

    public void rightInsertInList(String listKey, String value) {
	try (Jedis connection = getJedis()) {
	    connection.rpush(listKey, value);
	}

    }

    public Set<String> getAllKeys() {
	try (Jedis connection = getJedis()) {
	    return connection.keys("*");
	}
    }

    public List<String> leftRange(String listKey, int left, int right) {
	return getJedis().lrange(listKey, left, right);
    }

}
