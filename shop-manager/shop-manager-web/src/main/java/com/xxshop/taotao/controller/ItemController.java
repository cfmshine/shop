package com.xxshop.taotao.controller;

import com.xxshop.taotao.entity.PaginationData;
import com.xxshop.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenfumin on 2016/12/29.
 */
@Controller
public class ItemController {

  @Autowired
  private ItemService itemService;

  @RequestMapping("/item/list")
  @ResponseBody
  public PaginationData getItemlist(@RequestParam(defaultValue = "1") Integer page, Integer rows) throws Exception {
    //查询商品列表
    PaginationData result = itemService.findAll(page, rows);
    return result;
  }

}
