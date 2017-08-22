package com.yeeton.modules.spider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yeeton.modules.spider.dao.AccountInfoFindDao;
import com.yeeton.modules.spider.domain.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/6/29.
 */
@Service
public class AccountInfoFindService {

    @Autowired
    AccountInfoFindDao accountInfoFindDao;

    public PageInfo<AccountInfo> select(AccountInfo keywords, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<AccountInfo> list = accountInfoFindDao.select(keywords);
        return  new PageInfo<>(list);
    }

    @Transient
    public Long add(AccountInfo keywords){
       return accountInfoFindDao.insert(keywords);
    }

    @Transient
    public Integer delete(Long[] ids){
        return accountInfoFindDao.deleteByPrimaryKeyArray(ids);
    }

    public List<AccountInfo> selectByPrimaryKeys(Long[] idArray){
        return accountInfoFindDao.selectByPrimaryKeys(idArray);
    }

    @Transient
    public Integer batchAdd(List<AccountInfo> accountInfoList){
        return accountInfoFindDao.insertBatch(accountInfoList);
    }

}
