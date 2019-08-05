package stringOperations;

import java.util.List;
import java.util.Set;

import jedis.ApplicationCache;
import jedis.JedisConnectionPoolManager;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisOperations {
    
    public static void main(String[] args) throws Exception {
	System.out.println("Checking Connectivity ");
	ApplicationCache cache = JedisConnectionPoolManager.getInstance("localhost",6900).getCache();
	cache.setStringPair("customer#1", "Alpha");
	System.out.println("Retrieving the String pair");
	System.out.println("Retrieved Value for customer#1 = " + cache.getStringPair("customer#1"));
	System.out.println("======================List Operations==============================");
	System.out.println("Setting List of tutorials for the key = tutorial#1");
	cache.leftInsertInList("tutorial#1", "Bhajan&Pooja");
	cache.leftInsertInList("tutorial#1", "Bhakti");
	List<String> tutorials = cache.leftRange("tutorial#1", 0, 2);
	tutorials.stream().forEach(System.out::println);
    }
}
