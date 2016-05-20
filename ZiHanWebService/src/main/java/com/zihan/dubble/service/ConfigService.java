package com.zihan.dubble.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zihan.dubble.dao.datasource1.ConfigDao;
import com.zihan.dubble.dao.datasource2.ConfigDao2;
import com.zihan.dubble.entry.Config;

/**
 * 网站配置
 * 
 * @author Zihan
 * 
 */
@Service
public class ConfigService {

	@Resource
	private ConfigDao configDao;
	@Resource
	private ConfigDao2 configDao2;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加配置
	 * 
	 * @param key
	 * @param value
	 * @return Config
	 */
	public Config addConfig(String key, String value) {
		Config config = new Config();
		config.setKey(key);
		config.setValue(value);
		config.setCreateTime(new Date());
		configDao.addConfig(config);
		return config;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除配置
	 * 
	 * @param key
	 * @return Integer
	 */
	public int deleteConfigByKey(String key) {
		return configDao.deleteConfig(key);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 更新配置
	 * 
	 * @param key
	 * @param value
	 */
	public Config updateConfigByKey(String key, String value) {
		Config config = configDao.getConfigByKey(key);
		config.setValue(value);
		configDao.updateConfig(config);
		Config config2 = configDao2.getConfigByKey(key);
		config2.setValue(value);
		configDao2.updateConfig(config2);
		this.getStringByKey(key);
		return config;
	}

	/**
	 * @param key
	 * @return
	 */
	public String getStringByKey(String key) {
		Config config = configDao.getConfigByKey(key);
		if (config == null) {
			return "";
		} else {
			return config.getValue();
		}
	}

	/**
	 * @param key
	 * @return
	 */
	public int getIntKey(String key) {
		Config config = configDao.getConfigByKey(key);
		if (config == null) {
			return 0;
		} else {
			return Integer.parseInt(config.getValue());
		}
	}
}
