package com.mercury.mallproject.framework.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mercury.mallproject.common.enums.ResultEnum;
import com.mercury.mallproject.common.response.R;
import com.mercury.mallproject.common.utils.DateUtils;
import com.mercury.mallproject.common.utils.StringUtils;
import com.mercury.mallproject.framework.page.PageDomain;
import com.mercury.mallproject.framework.page.TableDataInfo;
import com.mercury.mallproject.framework.page.TableSupport;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;


/**
 * web层通用数据处理
 */
public class BaseController
{
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(ResultEnum.SUCCESS.getCode().intValue());
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public R success()
    {
        return R.ok();
    }

    /**
     * 返回失败消息
     */
    public R error()
    {
        return R.error();
    }

    /**
     * 返回成功消息
     */
    public R success(String message)
    {
        return R.ok(message);
    }

    /**
     * 返回失败消息
     */
    public R error(String message)
    {
        return R.error(message);
    }

    /**
     * 返回错误码消息
     */
    public R error(int code, String message)
    {
        return R.error(code, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

//    public User getSysUser()
//    {
//        return ShiroUtils.getSysUser();
//    }
//
//    public void setSysUser(User user)
//    {
//        ShiroUtils.setSysUser(user);
//    }
//
//    public Long getUserId()
//    {
//        return getSysUser().getUserId();
//    }
//
//    public String getLoginName()
//    {
//        return getSysUser().getLoginName();
//    }
}
