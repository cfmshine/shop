package com.xxshop.taotao.config;

import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * 常量类
 * Created by chenfumin on 2016/12/29.
 */
public final class Constants {

  private static final PropertiesLoader PROPERTIES_LOADER = new PropertiesLoader("classpath:config.properties");

  private static final Map<String, String> CACHE = Maps.newHashMap();

  public static final Integer PAGE_SIZE = Integer.valueOf(CACHE.get("page.pageSize"));

  public static String getConfig(String key) {
    String value = CACHE.get(key);
    if (StringUtils.isNotBlank(value)) {
      value = PROPERTIES_LOADER.getProperty(key);
      CACHE.put(key, value);
    }
    return value;
  }

  public static String getConfig(String key, String defaultValue) {
    String value = CACHE.get(key);
    if (StringUtils.isNotBlank(value)) {
      value = PROPERTIES_LOADER.getProperty(key, defaultValue);
      CACHE.put(key, value);
    }
    return value;
  }
}
