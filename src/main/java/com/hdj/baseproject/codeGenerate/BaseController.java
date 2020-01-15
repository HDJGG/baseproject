package com.hdj.baseproject.codeGenerate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 控制层基础类
 *
 * @param <T> 这个泛型，目前是ORACLE的，如果后面有MYSQL这些，则可以在增加一个新的泛型
 * @author hdj
 */
public abstract class BaseController<T extends BaseBean> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    public abstract BaseService<T> getService();


    /**
     * 根据对象有值的字段作为有效值进行筛选查找（单条数据[JSON数据格式]）
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/getData", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo getData(HttpServletRequest request, HttpServletResponse response, T t) {
        List<T> ts = getService().selectSelective(t);
        if (null != ts && ts.size() > 0) {
            return ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(), ts.get(0), ts.size());
        }
        return ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(), null);
    }

    /**
     * 根据对象有值的字段作为有效值进行筛选查找数据是否已存在
     *
     * @param request
     * @param response
     * @param t
     * @return Map<String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           Boolean>
     * @author hdj
     */
    @RequestMapping(value = "/isExists", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected Map<String, Boolean> isExists(HttpServletRequest request, HttpServletResponse response, T t) {

        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }

        List<T> ts = getService().selectSelective(t);
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        if (null != ts && ts.size() > 0) {
            result.put("valid", true);
            return result;
        }
        result.put("valid", false);
        return result;
    }

    /**
     * 根据对象有值的字段作为有效值进行筛选查找数据是否不存在
     *
     * @param request
     * @param response
     * @param t
     * @return Map<String               Boolean>
     * @author hdj
     */
    @RequestMapping(value = "/isNotExists", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected Map<String, Boolean> isNotExists(HttpServletRequest request, HttpServletResponse response, T t) {

        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }

        List<T> ts = getService().selectSelective(t);
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        if (null != ts && ts.size() > 0) {
            result.put("valid", false);
            return result;
        }
        result.put("valid", true);
        return result;
    }

    /**
     * 根据对象有值的字段作为有效值进行筛选查找（多条数据[JSON数组的数据格式]）
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/getDatas", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo getDatas(HttpServletRequest request, HttpServletResponse response, T t) {
        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        List<T> ts = getService().selectSelective(t);
        return ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(), ts, ts.size());
    }

    /**
     * 查询所有记录数
     *
     * @param request
     * @param response
     * @return ResultVo
     * @author hdj
     */
    /*  @RequestMapping(value = "/getSumCountSize", method = {RequestMethod.GET, RequestMethod.POST})*/
    /*  @ResponseBody*/
    /*  protected ResultVo getSumCountSize(HttpServletRequest request, HttpServletResponse response) {*/
    /*      return ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(), getService().selectDataCountSize(null,
    null));*/
    /*  }*/

    /**
     * 根据条件查询记录数，绝对值匹配
     *
     * @param request
     * @param response
     * @param condition
     * @return ResultVo
     * @author hdj
     */
    /* @RequestMapping(value = "/getCountSize", method = {RequestMethod.GET, RequestMethod.POST})*/
    /* @ResponseBody*/
    /* protected ResultVo getCountSize(HttpServletRequest request, HttpServletResponse response,*/
    /*                                 @RequestParam Map<String, Object> condition) {*/
    /*     return ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(), getService().selectDataCountSize(condition,*/
    /*             null));*/
    /* }*/

    /**
     * 获取到分页列表数据
     * @author hdj
     * @param request
     * @param response
     * @param pageVo
     * @param pageSize
     * @param pageNumber
     * @return ResultVo
     */
//	@RequestMapping(value = "/getPagingList", method = {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//    protected ResultVo getPagingList(HttpServletRequest request, HttpServletResponse response,PageVo<T> pageVo,
// Integer pageSize, Integer pageNumber) {
//		pageVo.setPageSize(pageSize);
//		pageVo.setCurPage(pageNumber);
//		PageVo<T> pageVoResult = getService().selectPageSelective(pageVo.getCurPage(),pageVo.getPageSize(),pageVo
// .getOrderField(),pageVo.getOrderingRule(),pageVo.getFiltrate(),pageVo.getLikeFiltrate());
//		ResultVo resultVo = ResultVo.getSuccess(HttpResponseEnum.SUCCESS.getValue(),pageVoResult);
//		resultVo.setTotalCount(pageVoResult.getTotalCount());
//		resultVo.setResult(pageVoResult.getPageData());
//		return resultVo;
//    }

    /**
     * 保存
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo save(HttpServletRequest request, HttpServletResponse response, T t) {
//		UserMySqlBean userBean = getCurrentUser(request);
        try {
//			ReflectUtils.setFieldDefVal(t,DefFieldNameEnum.CREATOR.getValue(),userBean.getAccount());
//			ReflectUtils.setFieldDefVal(t,DefFieldNameEnum.UPDATOR.getValue(),userBean.getAccount());
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.N.getValue());
            int len = getService().insertSelective(t);
            return ResultVo.getSuccess(HttpResponseCurdEnum.SAVE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.SAVE_FAIL.getValue());
    }

    /**
     * 更新默认使用id
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo update(HttpServletRequest request, HttpServletResponse response, T t) {
//		UserMySqlBean userBean = getCurrentUser(request);
        try {
//			ReflectUtils.setFieldDefVal(t,DefFieldNameEnum.UPDATOR.getValue(),userBean.getAccount());
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.UPDATE_TIME.getValue(), new Date().toString());
            int len = getService().updateSelectiveOfId(t);
            return ResultVo.getSuccess(HttpResponseCurdEnum.UPDATE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.UPDATE_FAIL.getValue());
    }

    /**
     * 根据id删除一个(逻辑删除)
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo deleteById(HttpServletRequest request, HttpServletResponse response, T t) {
//		UserMySqlBean userBean = getCurrentUser(request);
        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.Y.getValue());
//			ReflectUtils.setFieldDefVal(t,DefFieldNameEnum.UPDATOR.getValue(),userBean.getAccount());
//            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.UPDATE_TIME.getValue(), new Date().toString());
            int len = getService().updateSelectiveOfId(t);
            return ResultVo.getSuccess(HttpResponseCurdEnum.DELETE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.DELETE_FAIL.getValue());
    }

    /**
     * 根据Id删除多个，使用(,)分割，(逻辑删除)
     *
     * @param request
     * @param response
     * @param t
     * @param ids
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo deleteByIds(HttpServletRequest request, HttpServletResponse response, T t, String ids) {
//		UserMySqlBean userBean = getCurrentUser(request);
        String[] idStrings = ids.split(",");

        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.Y.getValue());
//			ReflectUtils.setFieldDefVal(t,DefFieldNameEnum.UPDATOR.getValue(),userBean.getAccount());
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.UPDATE_TIME.getValue(), new Date().toString());
            int len = 0;
            if (null != idStrings && idStrings.length > 0) {
                Integer[] integers = DataTypeChangeUtils.strArrToIntArr(idStrings);
                List<Integer> idsArr = Arrays.asList(integers);
                len = getService().batchUpdateOfIds(t, idsArr);
            } else {
                ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.ID.getValue(), ids);
                len = getService().updateSelectiveOfId(t);
            }
            return ResultVo.getSuccess(HttpResponseCurdEnum.DELETE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.DELETE_FAIL.getValue());
    }


    /**
     * 根据id删除一个(逻辑删除)
     *
     * @param request
     * @param response
     * @param t
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/deletePhysical", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo deletePhysicalById(HttpServletRequest request, HttpServletResponse response, T t) {
        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.Y.getValue());
            int len = getService().updateSelectiveOfId(t);
            return ResultVo.getSuccess(HttpResponseCurdEnum.DELETE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.DELETE_FAIL.getValue());
    }

    /**
     * 根据Id删除多个，使用(,)分割，(逻辑删除)
     *
     * @param request
     * @param response
     * @param t
     * @param ids
     * @return ResultVo
     * @author hdj
     */
    @RequestMapping(value = "/deletesPhysical", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    protected ResultVo deletePhysicalByIds(HttpServletRequest request, HttpServletResponse response, T t, String ids) {
        String[] idStrings = ids.split(",");

        try {
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.IS_DELETE.getValue(), IsDeleteEnum.Y.getValue());
            ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.UPDATE_TIME.getValue(), new Date().toString());
            int len = 0;
            if (null != idStrings && idStrings.length > 0) {
                Integer[] integers = DataTypeChangeUtils.strArrToIntArr(idStrings);
                List<Integer> idsArr = Arrays.asList(integers);
                len = getService().batchUpdateOfIds(t, idsArr);
            } else {
                ReflectUtils.setFieldDefVal(t, DefFieldNameEnum.ID.getValue(), ids);
                len = getService().updateSelectiveOfId(t);
            }
            return ResultVo.getSuccess(HttpResponseCurdEnum.DELETE_SUCCESS.getValue(), len);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return ResultVo.getSystemError(HttpResponseCurdEnum.DELETE_FAIL.getValue());
    }


    /**
     * 获取到当前用户
     * @author hdj
     * @param request
     * @return UserMySqlBean
     */
	/*protected UserMySqlBean getCurrentUser(HttpServletRequest request) {
		UserMySqlBean userBean = new UserMySqlBean();
		userBean.setAccount("system");
		return userBean;
	}*/


}
