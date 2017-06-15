package cn.itcast.springboot.conf;

import java.nio.charset.Charset;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * tomcat 配置
 * 
 */
@Configuration
public class TomcatConfig {

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.setUriEncoding(Charset.forName("utf-8"));
		tomcat.setPort(8090);
		return tomcat;
	}

}
