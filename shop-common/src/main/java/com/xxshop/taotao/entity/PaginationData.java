package com.xxshop.taotao.entity;

import java.util.List;

/**
 * Created by chenfumin on 2016/12/28.
 */
public class PaginationData {
  private Integer total;

  private List<?> rows;

  public PaginationData(Integer total, List<?> rows) {
    this.total = total;
    this.rows = rows;
  }

  public PaginationData(Long total, List<?> rows) {
    this.total = total.intValue();
    this.rows = rows;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<?> getRows() {
    return rows;
  }

  public void setRows(List<?> rows) {
    this.rows = rows;
  }
}
