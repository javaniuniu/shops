package com.javaniuniu.shops.service;

import com.javaniuniu.shops.model.News;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:32 PM
 */
//@Slf4j
public abstract class BaseService implements
        IBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected <T> T doIt(Page<News> page, T resultClass, ProcessInvoker processInvoker) {
        T result = initResult();
        processInvoker.process();
        return result;
    }

    private <T> T initResult() {
        return null;
    }
}