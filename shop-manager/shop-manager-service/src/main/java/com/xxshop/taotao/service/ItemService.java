package com.xxshop.taotao.service;

import com.xxshop.taotao.entity.PaginationData;

/**
 * Created by chenfumin on 2016/12/29.
 */
public interface ItemService {
  PaginationData findAll(Integer pageNo, Integer rows);
}
