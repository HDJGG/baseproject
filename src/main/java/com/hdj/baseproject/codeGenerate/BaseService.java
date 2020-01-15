package com.hdj.baseproject.codeGenerate;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 自定义基础业务接口
 *
 * @author hdj
 */
public interface BaseService<T extends BaseBean> {


    /**
     * 根据主键查询数据（联合主键情况下，每个字段都必须传入参数）
     */
    T queryByPrimaryKey(T record);

    /**
     * 根据主键更新对象
     *
     * @param t
     * @return
     */
    Integer updateByPrimaryKey(T t);

    /**
     * 根据主键删除对象
     *
     * @param t
     * @return
     */
    Integer deleteByPrimaryKey(T t);

    /**
     * 动态分页，筛选条件 - 默认为最新时间排序
     *
     * @param curPage      当前页
     * @param pageSize     每页的数据条数
     * @param orderField   排序字段
     * @param orderingRule 排序规则：ASC / DESC
     * @param filtrate     筛选信息 - 数据库字段名 = 值
     * @param likeFiltrate 模糊筛选
     * @return PageVo<T>
     * @author hdj
     */
//    PageVo<T> selectPageSelective(int curPage, int pageSize,
//                                  String orderField, String orderingRule,
//                                  Map<String, Object> filtrate, Map<String, Object> likeFiltrate);

    /**
     * 根据对象的不为null的值作为条件进行查找，并且确定值找出一个值
     *
     * @param record
     * @return T
     * @author hdj
     */
//    T selectOnlyOfSelective(T record);

    /**
     * 查询列表数据，但条件删除是N
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    List<T> selectSelectiveOfIsDeleteN(T record);

    /**
     * 根据对象的不为null的值作为条件进行查找
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    List<T> selectSelective(T record);



    /**
     * 根据对象的不为null的值(排除主键)，且排除根绝主键排除当前对象
     */
    List<T> selectSelectiveSkipSelf(T record);

    /**
     * 动态分页，筛选条件 - 默认为最新时间排序
     *
     * @param pageVo
     * @return List<T>
     * @author hdj
     */
//    List<T> selectPageSelective(PageVo<T> pageVo);

    /**
     * 根据条件查找对应的统计数
     *
     * @param condition
     * @param likeCondition
     * @return Integer
     * @author hdj
     */
    Integer selectDataCountSize(Map<String, Object> condition, Map<String, Object> likeCondition);

    /**
     * 根据Id进行查询
     *
     * @param id
     * @return T
     * @author hdj
     */
    T selectOfId(Integer id);

    /**
     * 根据多个Id进行查询
     *
     * @param id
     * @return List<T>
     * @author hdj
     */
    List<T> selectOfIds(List<Integer> id);

    /**
     * 根据Id范围进查询
     *
     * @param lessId
     * @param largeId
     * @return List<T>
     * @author hdj
     */
    List<T> selectOfIdScopes(Integer lessId, Integer largeId);

    /**
     * 根据多条件值进行查询
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    List<T> selectSelectiveMany(List<T> record);

    /**
     * 根据条件进行查询去重
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    List<T> selectSelectiveOfDistince(T record);

    /**
     * 根据多条件值进行查询去重
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    List<T> selectSelectiveManyOfDistince(List<T> record);

    /**
     * 根据对象的不为null的值作为条件进行删除
     *
     * @param record
     * @return Integer
     * @author hdj
     */
    Integer deleteSelective(T record);

    /**
     * 根据Id进行删除
     *
     * @param id
     * @return Integer
     * @author hdj
     */
    Integer deleteSelectiveOfId(Integer id);

    /**
     * 根据多个Id进行删除
     *
     * @param ids
     * @return Integer
     * @author hdj
     */
    Integer deleteSelectiveOfIds(List<Integer> ids);

    /**
     * 添加数据，只添加不为null的数据
     *
     * @param record
     * @return Integer
     * @author hdj
     */
    Integer insertSelective(T record);

    /**
     * 在插入之前判断是否存在，存在则不插入
     *
     * @param record
     * @return Integer
     * @author hdj
     */
    Integer insertSelectiveOfNotExist(T record);

    /**
     * 在插入之前判断是否存在，存在则不插入，查找条件是为未删除的数据
     *
     * @param record
     * @return List<T>
     * @author hdj
     */
    Integer insertSelectiveByNotExistOfIsDeleteN(T record);

    /**
     * 批量添加数据，添加所有字段的数据
     *
     * @param record
     * @return Integer
     * @author hdj
     */
    Integer batchInsert(@Param("batchField") List<T> record);

    /**
     * 批量添加数据，添加动态字段的数据，建议每次100条
     *
     * @param record
     * @return Integer
     * @author hdj
     */
    Integer batchInsertSelective(List<T> record);

    /**
     * 更新不为null的数据，不会将其他字段更新为null
     *
     * @param updateRecord
     * @param conditionRecord
     * @return Integer
     * @author hdj
     */
    Integer updateSelective(T updateRecord, T conditionRecord);

    /**
     * 根据Id作为条件进行更新
     *
     * @param updateRecord
     * @return Integer
     * @author hdj
     */
    Integer updateSelectiveOfId(T updateRecord);


    /**
     * 根据批量Id进行更新
     *
     * @param updateRecord
     * @param ids
     * @return Integer
     * @author hdj
     */
    Integer batchUpdateOfIds(T updateRecord, List<Integer> ids);

    /**
     * 根据批量Id进行更新
     *
     * @param updateRecord
     * @param ids
     * @param separator
     * @return Integer
     * @author hdj
     */
    Integer batchUpdateOfIds(T updateRecord, String ids, String separator);

    /**
     * 根据批量Id进行更新
     *
     * @param updateRecord
     * @param ids
     * @return Integer
     * @author hdj
     */
    Integer batchUpdateOfIds(T updateRecord, String[] ids);

    /**
     * 是否存在
     *
     * @param t
     * @return boolean
     * @author hdj
     */
    boolean isExists(T t);

    /**
     * 根据条件逻辑删除
     *
     * @param conditionRecord
     * @return Integer
     * @author hdj
     */
    Integer logicDelete(T conditionRecord);


}
