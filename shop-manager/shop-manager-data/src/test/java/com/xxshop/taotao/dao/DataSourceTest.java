package com.xxshop.taotao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenfumin on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-data.xml")
public class DataSourceTest {

  @Resource
  private DataSource dataSource;

  @Test
  public void testDataSource() {
    Assert.assertNotNull(dataSource);
    try {
      Connection connection = dataSource.getConnection();
      Assert.assertNotNull(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
