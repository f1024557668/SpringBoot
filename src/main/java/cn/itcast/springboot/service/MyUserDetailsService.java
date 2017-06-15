package cn.itcast.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.itcast.springboot.model.User;

@Component("userService")
public class MyUserDetailsService implements UserDetailsService {

	private static Logger logger = Logger.getLogger(MyUserDetailsService.class);

	private static Map<String, User> userMap = new HashMap<String, User>();
	static {
		User user = new User("test", "123456", "ADMIN");
		userMap.put(user.getUsername(), user);
		user = new User("admin", "admin", "USER");
		userMap.put(user.getUsername(), user);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userMap.get(s);
		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		logger.info("username:" + user.getUsername() + ",role:" + user.getRole());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}