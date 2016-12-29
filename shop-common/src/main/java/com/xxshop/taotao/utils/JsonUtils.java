package com.xxshop.taotao.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxshop.taotao.exception.TaotaoException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 进行Json解析，Java对象转换Json字符串等操作
 * Created by chenfumin on 2016/12/28.
 */
public class JsonUtils {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String object2Json(Object object) {
    String result = null;
    try {
      Objects.requireNonNull(object, "JsonUtils: The object must not be empty.");
      result = objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new TaotaoException("JsonUtils: object convert json string fail.");
    }
    return result;
  }
}
