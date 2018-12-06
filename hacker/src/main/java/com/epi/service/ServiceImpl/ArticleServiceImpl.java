package com.epi.service.ServiceImpl;

import com.epi.bean.Article;
import com.epi.bean.Reply;
import com.epi.bean.Words;
import com.epi.dao.ArticleMapper;
import com.epi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void insertProject(Article good) {
        articleMapper.insertSelective(good);
    }

    @Override
    public void saveWords(Words words) {
        articleMapper.saveWords(words);
    }

    @Override
    public void saveReply(Reply reply) {
        articleMapper.saveReply(reply);
    }

    @Override
    public List<Words> findByWords() {
        return articleMapper.findByWords();
    }

    @Override
    public List<Reply> findByReply() {
        return articleMapper.findByReply();
    }

    @Override
    public Article findById(int r_id) {
        return articleMapper.selectByPrimaryKey(r_id);
    }

    @Override
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public List<Article> searchAll(String text) {
        return articleMapper.searchAll(text);
    }

    @Override
    public List<Article> findBySort(String sort) {
        return articleMapper.findBySort(sort);
    }

}
