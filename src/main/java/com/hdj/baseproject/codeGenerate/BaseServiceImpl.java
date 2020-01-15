package com.hdj.baseproject.codeGenerate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义基础业务抽象实现类
 *
 * @author hdj
 */
//@Service("baseOracleService")
public abstract class BaseServiceImpl<T extends BaseBean> implements BaseService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    protected abstract BaseMapper<T> getMapper();


    @Override
    public T queryByPrimaryKey(T record) {
        try {
            if (null == record) {
                record = (T) record.getClass().newInstance();
            }
            ReflectUtils.setFieldDefVal(record, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
            return getMapper().queryByPrimaryKey(record);
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateByPrimaryKey(T record) {
        try {
            if (null == record) {
                record = (T) record.getClass().newInstance();
            }
            ReflectUtils.setFieldDefVal(record, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
            return getMapper().updateByPrimaryKey(record);
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteByPrimaryKey(T record) {
        try {
            if (null == record) {
                record = (T) record.getClass().newInstance();
            }
            ReflectUtils.setFieldDefVal(record, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
            return getMapper().deleteByPrimaryKey(record);
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> selectSelectiveOfIsDeleteN(T record) {
        try {
            if (null == record) {
                record = (T) record.getClass().newInstance();
            }
            ReflectUtils.setFieldDefVal(record, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
            return getMapper().selectSelective(record);
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<T> selectSelective(T record) {
        return getMapper().selectSelective(record);
    }

    @Override
    public List<T> selectSelectiveSkipSelf(T record) {
        return getMapper().selectSelective(record);
    }

    @Override
    public Integer selectDataCountSize(Map<String, Object> condition, Map<String, Object> likeCondition) {
        return getMapper().selectDataCountSize(condition, likeCondition);
    }

    /*
     * 根据Id进行查询
     * @author hdj
     * @param id
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectOfId(java.lang.Integer)
     */
    @Override
    public T selectOfId(Integer id) {
        return getMapper().selectOfId(id);
    }

    /*
     * 根据多个Id进行查询
     * @author hdj
     * @param id
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectOfIds(java.util.List)
     */
    @Override
    public List<T> selectOfIds(List<Integer> id) {
        return getMapper().selectOfIds(id);
    }

    /*
     * 根据Id范围进查询
     * @author hdj
     * @param lessId
     * @param largeId
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectOfIdScopes(java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<T> selectOfIdScopes(Integer lessId, Integer largeId) {
        return getMapper().selectOfIdScopes(lessId, largeId);
    }

    /*
     * 根据多条件值进行查询
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectSelectiveMany(java.util.List)
     */
    @Override
    public List<T> selectSelectiveMany(List<T> record) {
        return getMapper().selectSelectiveMany(record);
    }

    /*
     * 根据条件进行查询去重
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectSelectiveOfDistince(java.lang.Object)
     */
    @Override
    public List<T> selectSelectiveOfDistince(T record) {
        return getMapper().selectSelectiveOfDistince(record);
    }

    /*
     * 根据多条件值进行查询去重
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#selectSelectiveManyOfDistince(java.util.List)
     */
    @Override
    public List<T> selectSelectiveManyOfDistince(List<T> record) {
        return getMapper().selectSelectiveManyOfDistince(record);
    }

    /*
     * 根据对象的不为null的值作为条件进行删除
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#deleteSelective(java.lang.Object)
     */
    @Override
    public Integer deleteSelective(T record) {
        return getMapper().deleteSelective(record);
    }

    /*
     * 根据Id进行删除
     * @author hdj
     * @param id
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#deleteSelectiveOfId(java.lang.Integer)
     */
    @Override
    public Integer deleteSelectiveOfId(Integer id) {
        return getMapper().deleteSelectiveOfId(id);
    }

    /*
     * 根据多个Id进行删除
     * @author hdj
     * @param ids
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#deleteSelectiveOfIds(java.util.List)
     */
    @Override
    public Integer deleteSelectiveOfIds(List<Integer> ids) {
        return getMapper().deleteSelectiveOfIds(ids);
    }

    /*
     * 添加数据，只添加不为null的数据
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#insertSelective(java.lang.Object)
     */
    @Override
    public Integer insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    /*
     * 在插入之前判断是否存在，存在则不插入
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.analysis.service.BaseService#insertSelectiveOfNotExist(java.lang.Object)
     */
    @Override
    public Integer insertSelectiveOfNotExist(T record) {
        List<T> exists = this.selectSelective(record);
        if (null == exists || exists.size() <= 0) {
            return this.insertSelective(record);
        }
        return 0;
    }

    /*
     * 在插入之前判断是否存在，存在则不插入，查找条件是为未删除的数据
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.analysis.service.BaseService#insertSelectiveOfNotExist(java.lang.Object)
     */
    @Override
    public Integer insertSelectiveByNotExistOfIsDeleteN(T record) {
        List<T> exists = this.selectSelectiveOfIsDeleteN(record);
        if (null == exists || exists.size() <= 0) {
            return this.insertSelective(record);
        }
        return 0;
    }

    /*
     * 批量添加数据，添加所有字段的数据
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#batchInsert(java.util.List)
     */
    @Override
    public Integer batchInsert(List<T> record) {
        return getMapper().batchInsert(record);
    }

    /*
     * 批量添加数据，添加动态字段的数据，建议每次100条
     * @author hdj
     * @param record
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#batchInsertSelective(java.util.List)
     */
    @Override
    public Integer batchInsertSelective(List<T> record) {
        return getMapper().batchInsertSelective(record);
    }

    /*
     * 更新不为null的数据，不会将其他字段更新为null
     * @author hdj
     * @param updateRecord
     * @param conditionRecord
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#updateSelective(java.lang.Object, java.lang.Object)
     */
    @Override
    public Integer updateSelective(T updateRecord, T conditionRecord) {
        return getMapper().updateSelective(updateRecord, conditionRecord);
    }

    /*
     * 根据Id作为条件进行更新
     * @author hdj
     * @param updateRecord
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#updateSelectiveOfId(java.lang.Object)
     */
    @Override
    public Integer updateSelectiveOfId(T updateRecord) {
        return getMapper().updateSelectiveOfId(updateRecord);
    }

    /*
     * 根据批量Id进行更新
     * @author hdj
     * @param updateRecord
     * @param ids
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#batchUpdateOfIds(java.lang.Object, java.util.List)
     */
    @Override
    public Integer batchUpdateOfIds(T updateRecord, List<Integer> ids) {
        return getMapper().batchUpdateOfIds(updateRecord, ids);
    }

    /*
     * 是否存在
     * @author hdj
     * @param t
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#isExists(java.lang.Object)
     */
    @Override
    public boolean isExists(T t) {
        List<T> ts = getMapper().selectSelective(t);
        if (null != ts && ts.size() > 0) {
            return true;
        }
        return false;
    }

    /*
     * 根据批量Id进行更新
     * @author hdj
     * @param updateRecord
     * @param ids
     * @param separator
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#batchUpdateOfIds(java.lang.Object, java.lang.String,
     * java.lang.String)
     */
    @Override
    public Integer batchUpdateOfIds(T updateRecord, String ids, String separator) {
        String[] idArr = ids.split(separator);
        List<Integer> idsList = new ArrayList<>();
        for (String string : idArr) {
            idsList.add(Integer.parseInt(string));
        }
        return getMapper().batchUpdateOfIds(updateRecord, idsList);
    }

    /*
     * 批量Id删除
     * @author hdj
     * @param updateRecord
     * @param ids
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#batchUpdateOfIds(java.lang.Object, java.lang.String[])
     */
    @Override
    public Integer batchUpdateOfIds(T updateRecord, String[] ids) {
        List<Integer> idsList = new ArrayList<>();
        for (String string : ids) {
            idsList.add(Integer.parseInt(string));
        }
        return getMapper().batchUpdateOfIds(updateRecord, idsList);
    }

    /*
     * 根据条件逻辑删除
     * @author hdj
     * @param conditionRecord
     * @return
     * @overridden @see com.aimspeed.creeper.service.BaseService#logicDelete(java.lang.Object)
     */
    @Override
    public Integer logicDelete(T conditionRecord) {

        try {
            T updateRecord = (T) conditionRecord.getClass().newInstance();
            ReflectUtils.setFieldDefVal(updateRecord, "isDelete", "Y");
            return getMapper().updateSelective(updateRecord, conditionRecord);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
