package com.epi.service;

import com.epi.bean.Article;
import com.epi.bean.Reply;
import com.epi.bean.Words;

import java.util.List;

public interface ArticleService {
    void insertProject(Article good);

    void saveWords(Words words);

    void saveReply(Reply reply);

    List<Words> findByWords();

    List<Reply> findByReply();

    Article findById(int r_id);

}
