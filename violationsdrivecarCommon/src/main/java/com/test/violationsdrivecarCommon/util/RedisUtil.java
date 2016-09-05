package com.test.violationsdrivecarCommon.util;



import java.util.ResourceBundle;
import java.util.Set;



import com.test.violationsdrivecarCommon.exception.ApplicationException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil{

	private static JedisPool jedisPool = null;
	private static ResourceBundle  resourceBundle = ResourceBundle.getBundle("parameter");
	private static String REDISIP = resourceBundle.getString("redisIp");
	private static String REDISPORT = resourceBundle.getString("redisPort");

	private static JedisPool getPool() throws ApplicationException{

		if(jedisPool == null){
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			//最大连接数, 默认8个
			jedisPoolConfig.setMaxTotal(500);
			//最大空闲连接数, 默认8个
			jedisPoolConfig.setMaxIdle(5);
			//获取连接时的最大等待毫秒数
			jedisPoolConfig.setMaxWaitMillis(100000L);

			jedisPoolConfig.setTestOnBorrow(true);
			jedisPool = new JedisPool(jedisPoolConfig,REDISIP,Integer.valueOf(REDISPORT));
			System.out.println("REDISIP:" + REDISIP);
			System.out.println("REDISPORT:" + REDISPORT);
		}
		return jedisPool;
	}

	private static void returnResource(JedisPool jedisPool,Jedis jedis){
		if(jedis != null) jedisPool.returnResource(jedis);
	}
	/**
	 * key对应的value自增
	 * @param key
	 * @param num
	 * @return
	 * @throws ApplicationException 
	 */
	public static long incrBy(String key ,int num) throws ApplicationException{
		Long value = null;
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			value = jedis.incrBy(key,num);
		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
		return value;
		
	}
	public static String get(String key) throws ApplicationException{

		String value = null;
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			value = jedis.get(key);
		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
		return value;
	}
	public static void set(String key,String value) throws ApplicationException{
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			jedis.set(key,value);
		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
	}


	public static void setex(String key,String value,int time) throws ApplicationException{
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			jedis.setex(key,time,value);
		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
	}

	public static void del(String key) throws ApplicationException{
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			jedis.del(key);

		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
	}

	/**
	 * 
	 * @Description: 获得redis中所有的key
	 * @Detail:（方法详细描述） 
	 * @param beforeKey
	 * @return
	 * @throws ApplicationException 
	 */
	 public static Set<String> getKeys(String beforeKey) throws ApplicationException{
		Set<String> keys = null;
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try{
			jedisPool = getPool();
			jedis = (Jedis)jedisPool.getResource();
			keys = jedis.keys(beforeKey + "*");
		}catch(Exception ex){
			ex.printStackTrace();
			jedisPool.returnBrokenResource(jedis);
			throw new ApplicationException();
		}finally{
			returnResource(jedisPool,jedis);
		}
		return keys;
	 }

	 public static void flushDb() throws ApplicationException{

		 JedisPool jedisPool = null;
		 Jedis jedis = null;
		 try{
			 jedisPool = getPool();
			 jedis = (Jedis)jedisPool.getResource();
			 jedis.flushDB();
		 }catch(Exception ex){
			 ex.printStackTrace();
			 jedisPool.returnBrokenResource(jedis);
			 throw new ApplicationException();
		 }finally{
			 returnResource(jedisPool,jedis);
		 }
	 }
}
