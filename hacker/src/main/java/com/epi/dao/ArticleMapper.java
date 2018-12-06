package com.epi.dao;

import com.epi.bean.Article;

import java.util.List;

import com.epi.bean.Reply;
import com.epi.bean.Words;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {

    int deleteByPrimaryKey(Integer rId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    void saveWords(Words words);

    void saveReply(Reply reply);

    List<Words> findByWords();

    List<Reply> findByReply();

    List<Article> findAll();

    List<Article> searchAll(String text);

    List<Article> findBySort(String sort);
}