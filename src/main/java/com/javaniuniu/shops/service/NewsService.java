package com.javaniuniu.shops.service;

import com.javaniuniu.shops.common.Page;
import com.javaniuniu.shops.model.News;
import com.javaniuniu.shops.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 9:19 AM
 * 新闻模块Service
 */
@Service
@Transactional
public class NewsService extends BaseService {
    @Autowired
    NewsRepository newsDao;

    public void addNews(News news) {
        newsDao.save(news);
    }

    public void delNews(Integer newsId) {
        newsDao.deleteById(newsId);
    }

    //TODO 分页查询 newsDao.findAll(page.getPageable()).getContent()
    public List<News> findNews(Page<News> page) {
        page.setResult(newsDao.findAll(page.getPageable()).getContent());
        page.setTotalCount(newsDao.count());
        return page.getResult();
    }
    public News findById(Integer id) {
        return newsDao.getOne(id);
    }

}
