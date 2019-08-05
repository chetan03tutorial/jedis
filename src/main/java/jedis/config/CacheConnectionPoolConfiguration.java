package jedis.config;

import java.util.Map;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class CacheConnectionPoolConfiguration extends GenericObjectPoolConfig{

    private String host;
    private Integer port;
    
    public CacheConnectionPoolConfiguration(Map<String, String> configValue) {
	configure(configValue);
    }
    
    
    public String getHost() {
        return host;
    }


    public void setHost(String host) {
        this.host = host;
    }


    public Integer getPort() {
        return port;
    }


    public void setPort(Integer port) {
        this.port = port;
    }


    public void configure(Map<String, String> configValue) {
	// Read the configuration from the configValues
	GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
	conf.setMaxTotal(100);
	conf.setTestOnBorrow(false);
	conf.setTestOnReturn(false);
	conf.setTestOnCreate(false);
	conf.setTestWhileIdle(false);
	/*conf.setMinEvictableIdleTimeMillis(6);
	conf.setTimeBetweenEvictionRunsMillis(3);*/
	conf.setNumTestsPerEvictionRun(-1);
	conf.setFairness(true);
	conf.setMaxIdle(0);
    }
}
