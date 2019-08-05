package cache;

import redis.clients.jedis.Jedis;

public class AbstractApplicationCacheContext  implements ApplicationCacheContext, AutoCloseable {

    protected Jedis jedis;

    public AbstractApplicationCacheContext() {

    }

    public AbstractApplicationCacheContext(Jedis jedis) {
	this.jedis = jedis;
    }

    public void setJedis(Jedis jedis) {
	this.jedis = jedis;
    }

    public Jedis getJedis() {
        return jedis;
    }
    
    @Override
    public void close() throws Exception {
	Jedis jedisConnection = getJedis();
	// return the connection to the pool
	if (jedisConnection.isConnected()) {
	    jedisConnection.close();
	} else {
	    jedisConnection.disconnect();
	}
    }
    
}
