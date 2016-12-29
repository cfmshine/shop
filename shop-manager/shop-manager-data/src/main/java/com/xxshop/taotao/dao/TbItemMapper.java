package com.xxshop.taotao.dao;

import com.xxshop.taotao.annotation.MyBatisDao;
import com.xxshop.taotao.entity.TbItem;
import java.util.List;

/**
 * Created by chenfumin on 2016/12/28.
 */
@MyBatisDao
public interface TbItemMapper {

  List<TbItem> findAll();

}
