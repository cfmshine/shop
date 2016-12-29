package com.xxshop.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxshop.taotao.dao.TbItemMapper;
import com.xxshop.taotao.entity.PaginationData;
import com.xxshop.taotao.entity.TbItem;
import com.xxshop.taotao.service.ItemService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by chenfumin on 2016/12/29.
 */
@Service
public class ItemServiceImpl implements ItemService {

  @Resource
  private TbItemMapper itemMapper;

  public PaginationData findAll(Integer pageNo, Integer rows) {
    PageHelper.startPage(pageNo, rows);
    List<TbItem> tbItems = itemMapper.findAll();
    PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
    PaginationData pd = new PaginationData(pageInfo.getTotal(), tbItems);
    return pd;
  }

}
