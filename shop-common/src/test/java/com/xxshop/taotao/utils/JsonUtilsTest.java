package com.xxshop.taotao.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenfumin on 2016/12/28.
 */
public class JsonUtilsTest {

  @Test
  public void testObject2Json() {
    String result = JsonUtils.object2Json(new User("tom", 12));
    Assert.assertEquals("{\"name\":\"tom\",\"age\":12}", result);
  }

  public class User {

    private String name;
    private int age;

    public User(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }

}
