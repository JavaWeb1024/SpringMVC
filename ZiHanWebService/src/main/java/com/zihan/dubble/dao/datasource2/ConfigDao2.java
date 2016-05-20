/*



 */

package com.zihan.dubble.dao.datasource2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zihan.dubble.entry.Config;

/**
 * 网站配置
 * 
 * @author Zhangjiale
 * 
 */

@Repository("configdao2")
public interface ConfigDao2 {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加配置
	 * 
	 * @return Integer
	 */
	public int addConfig(Config config);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除配置
	 * 
	 * return Integer
	 */
	public int deleteConfig(@Param("key") String key);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 更新配置
	 * 
	 * @return Integer
	 */
	public int updateConfig(Config config);

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 查看配置
	 * 
	 * @return Config
	 */
	public Config getConfigByKey(@Param("key") String key);
}
