package cn.itcast.springboot.elasticsearch.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.itcast.springboot.elasticsearch.model.Article;

//泛型的参数分别是实体类型和主键类型
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
