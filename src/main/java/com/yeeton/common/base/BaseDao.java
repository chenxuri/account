package com.yeeton.common.base;


import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
public interface BaseDao<T,I> {


    /**
     * 通过主键查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(I id);

    /**
     * 根据条件查询
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 查询所有
     * @return
     */
    List<T>  selectAll();

    /**
     * 根据条件查询数量
     * @param t
     * @return
     * @return
     */
    Integer selectCount(T t);


    /**
     * 插入新数据
     * @param t
     * @return
     */
    I insert(T t);

    /**
     * 批量插入
     * @param list
     */
    Integer insertBatch(List<T> list);

    /**
     * 根据主键修改
     * @param
     * @return
     */
    Integer updateByPrimaryKey(T t);

    /**
     * 根据主键List修改
     * @param t
     * @return
     */
    Integer updateByPrimaryKeyList(T t);

    /**
     * 根据条件修改
     * @param t
     * @return
     */
    Integer  update(T t);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    Integer  deleteByPrimaryKey(I id);

    /**
     * 根据主键批量删除
     * @param idArray
     * @return
     */
    Integer  deleteByPrimaryKeyArray(I[] idArray);

    /**
     * 根据条件删除
     * @param t
     * @return
     */
    Integer delete(T t);

}
