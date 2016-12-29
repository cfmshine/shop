package com.xxshop.taotao.config;

import com.xxshop.taotao.exception.TaotaoException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 加载配置信息
 * Created by chenfumin on 2016/12/29.
 */
public class PropertiesLoader {

  private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

  private final Properties properties;

  private ResourceLoader loader = new DefaultResourceLoader();

  public PropertiesLoader(String... paths) {
    properties = loadProperties(paths);
  }

  private Properties loadProperties(String... paths) {
    Properties prop = new Properties();
    InputStream inputStream = null;
    Resource resource = null;
    try {
      for (String path : paths) {
        resource = loader.getResource(path);
        inputStream = resource.getInputStream();
        prop.load(inputStream);
      }
    } catch (Exception e) {
      throw new TaotaoException("PropertiesLoader: failed to load the resource file.");
    }
    return prop;
  }

  public String getProperty(String key, String defaultValue) {
    String value = getValue(key);
    if (StringUtils.isBlank(value)) {
      logger.info("PropertiesLoader: the specified key : " + key + " , value is not found ");
    }
    return defaultValue;
  }

  public String getProperty(String key) {
    String value = getValue(key);
    if (StringUtils.isBlank(value)) {
      throw new NoSuchElementException("PropertiesLoader: the specified key : " + key + " , value is not found ");
    }
    return value;
  }

  /**
   * 获取系统属性，以System为第一选择
   * @param key
   * @return
   */
  public String getValue(String key) {
    String value = null;
    if (StringUtils.isNotBlank(key)) {
      value = System.getProperty(key);
      if (properties.containsKey(key)) {
        return properties.getProperty(key);
      }
    }
    return value;
  }

}
