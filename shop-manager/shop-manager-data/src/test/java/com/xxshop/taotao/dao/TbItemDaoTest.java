package com.xxshop.taotao.dao;

import com.github.pagehelper.PageHelper;
import com.xxshop.taotao.entity.TbItem;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenfumin on 2016/12/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-data.xml")
public class TbItemDaoTest {

  @Resource
  private TbItemMapper tbItemMapper;

  @Test
  public void testFindAll() {
    PageHelper.startPage(1, 10);
    List<TbItem> tbItemList = tbItemMapper.findAll();
    Assert.assertEquals(tbItemList.size(), 10);
  }

}
