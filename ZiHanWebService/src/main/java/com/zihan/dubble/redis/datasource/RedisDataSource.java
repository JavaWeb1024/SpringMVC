package com.zihan.dubble.redis.datasource;

import redis.clients.jedis.ShardedJedis;

/**
 * 
 * @ClassName: RedisDataSource
 * @Description: TODO(redis接口)
 * @author 紫寒1120(zihan1120@gmail.com)
 * @date 2016年5月25日 下午3:10:57
 *
 */
public interface RedisDataSource {
	public abstract ShardedJedis getRedisClient();

	/**
	 * 
	* @Title: returnResource 
	* @Description: TODO(还会到连接池) 
	* @param @param shardedJedis    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void returnResource(ShardedJedis shardedJedis);

	/**
	 * false:利用连接池;true:销毁连接池
	* @Title: returnResource 
	* @Description: TODO(false:利用连接池;true:销毁连接池) 
	* @param @param shardedJedis
	* @param @param broken    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void returnResource(ShardedJedis shardedJedis, boolean broken);
}