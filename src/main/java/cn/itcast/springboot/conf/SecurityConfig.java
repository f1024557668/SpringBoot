package cn.itcast.springboot.conf;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import cn.itcast.springboot.service.MyUserDetailsService;

/**
 * @EnableWebSecurity: 
 *                     禁用Boot的默认Security配置，配合@Configuration启用自定义配置（需要扩展WebSecurityConfigurerAdapter
 *                     ）
 * @EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，例如最常用的@PreAuthorize
 *                                            configure(HttpSecurity):
 *                                            Request层面的配置，对应XML
 *                                            Configuration中的<http>元素
 *                                            configure(WebSecurity):
 *                                            Web层面的配置，一般用来配置无需安全检查的路径
 *                                            configure(
 *                                            AuthenticationManagerBuilder):
 *                                            身份验证配置，用于注入自定义身份验证Bean和密码校验规则
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = Logger.getLogger(SecurityConfig.class);

	/**
	 * security自定义用户权限
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

//	@Autowired
//	MyAuthenticationProvider provider;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	/**
	 * 第二执行
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.accessDecisionManager(accessDecisionManager())
				.expressionHandler(webSecurityExpressionHandler())
				.antMatchers("/", "/home")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				// 默认成功url
				.defaultSuccessUrl("/home")
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
		// http.sessionManagement().sessionFixation().changeSessionId().maximumSessions(1).expiredUrl("/");
	}

	/*
	 * 
	 * 这里可以增加自定义的投票器
	 */
//	@Bean(name = "accessDecisionManager")
//	public AccessDecisionManager accessDecisionManager() {
//		logger.info("AccessDecisionManager");
//		List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<AccessDecisionVoter<? extends Object>>();
//		decisionVoters.add(new RoleVoter());
//		decisionVoters.add(new AuthenticatedVoter());
//		decisionVoters.add(webExpressionVoter());// 启用表达式投票器
//
//		AffirmativeBased accessDecisionManager = new AffirmativeBased(decisionVoters);
//
//		return accessDecisionManager;
//	}

	/*
	 * 表达式控制器
	 */
	@Bean(name = "expressionHandler")
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		logger.info("DefaultWebSecurityExpressionHandler");
		DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		return webSecurityExpressionHandler;
	}

	/*
	 * 表达式投票器
	 */
	@Bean(name = "expressionVoter")
	public WebExpressionVoter webExpressionVoter() {
		logger.info("WebExpressionVoter");
		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler());
		return webExpressionVoter;
	}

	// /**
	// * 第三执行
	// */
	// @Override
	// public void configure(WebSecurity web) throws Exception {
	// web.ignoring().antMatchers("/js/**", "/css/**", "/images/**",
	// "/**/favicon.ico");
	// }
	//
	/**
	 * 首先执行
	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(provider);
//	}

}
