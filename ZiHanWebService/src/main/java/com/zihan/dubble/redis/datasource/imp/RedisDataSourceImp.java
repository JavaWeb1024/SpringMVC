package com.zihan.dubble.redis.datasource.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.zihan.dubble.redis.datasource.RedisDataSource;

@Repository
public class RedisDataSourceImp implements RedisDataSource {

	 private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImp.class);

	    @Autowired
	    private ShardedJedisPool    shardedJedisPool;

	    @Override
	    public ShardedJedis getRedisClient() {
	        try {
	            ShardedJedis shardJedis = shardedJedisPool.getResource();
	            return shardJedis;
	        } catch (Exception e) {
	            log.error("getRedisClent error", e);
	        }
	        return null;
	    }
		  
	    
	    @Override
	    public void returnResource(ShardedJedis shardedJedis) {
	        shardedJedisPool.returnResource(shardedJedis);
	    }
	    /**
	     * false:利用连接池;true:销毁连接池
	     */
	    @Override
	    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
	        if (broken) {
	        	 // 销毁对象  
	            shardedJedisPool.returnBrokenResource(shardedJedis);
	        } else {
	        	// 还会到连接池
	            shardedJedisPool.returnResource(shardedJedis);
	        }
	    }
	}

