package com.zihan.dubble.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zihan.dubble.redis.template.RedisClientTemplate;
import com.zihan.dubble.service.ConfigService;

@Controller
@RequestMapping("/config")
public class ConfigAction {
	
	@Autowired
	ConfigService configService;
	@Autowired
	RedisClientTemplate redisClientTemplate;
	
	@RequestMapping(value = "/config.jhtml", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request, ModelMap modelMap,
			String requestUrlString) {
		Map<String, String> map=new HashMap<String, String>();
		configService.getStringByKey("dinghao_seo_headline");
		map.put("requestUrlString", "测试");
		redisClientTemplate.set("zihan", "nihao");
		return map;
	}

}
