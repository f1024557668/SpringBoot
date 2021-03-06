package cn.itcast.springboot;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.itcast.springboot.elasticsearch.model.Article;
import cn.itcast.springboot.elasticsearch.model.Author;
import cn.itcast.springboot.elasticsearch.model.Tutorial;
import cn.itcast.springboot.elasticsearch.service.ArticleSearchRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ElasticSearchTest {

	@Autowired
	private ArticleSearchRepository articleSearchRepository;

	@Test
	public void testSaveArticleIndex() {
		Author author = new Author();
		author.setId(1L);
		author.setName("tianshouzhi");
		author.setRemark("java developer");

		Tutorial tutorial = new Tutorial();
		tutorial.setId(1L);
		tutorial.setName("elastic search");

		Article article = new Article();
		article.setId(1L);
		article.setTitle("springboot integreate elasticsearch");
		article.setAbstracts("springboot integreate elasticsearch is very easy");
		article.setTutorial(tutorial);
		article.setAuthor(author);
		article.setContent("elasticsearch based on lucene," + "spring-data-elastichsearch based on elaticsearch"
				+ ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
		article.setPostTime(new Date());
		article.setClickCount(1L);

		articleSearchRepository.save(article);
	}

	@Test
	public void testSearch() {
		String queryString = "1";// 搜索关键字
		QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
		Iterable<Article> searchResult = articleSearchRepository.search(builder);
		Iterator<Article> iterator = searchResult.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testTokenizer() throws UnknownHostException {
//		IndicesAdminClient indicesAdminClient = TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300)).admin().indices();
//		AnalyzeRequestBuilder request = new AnalyzeRequestBuilder(indicesAdminClient,"cloud_repair","中华人民共和国国歌");
// request.setAnalyzer("ik");
//		request.setTokenizer("ik");
// Analyzer（分析器）、Tokenizer（分词器）
//		List listAnalysis = request.execute().actionGet().getTokens();
//		System.out.println(listAnalysis);
	}
}
