package com.hdj.baseproject.codeGenerate;

import java.io.Serializable;

/**
 * 基础的Mysql类
 *
 * @author hdj
 */
public class BaseBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3047971221154628028L;

    /**
     * 是否删除 N非删除 Y删除
     **/
    private String isDelete;
    /**
     * mini ui分页属性
     */
    public String pageSize;
    public String pageIndex;
    public String synQuery;
    public String loadRowCount;
    public String sortField;
    public String sortOrder;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getSynQuery() {
        return synQuery;
    }

    public void setSynQuery(String synQuery) {
        this.synQuery = synQuery;
    }

    public String getLoadRowCount() {
        return loadRowCount;
    }

    public void setLoadRowCount(String loadRowCount) {
        this.loadRowCount = loadRowCount;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
