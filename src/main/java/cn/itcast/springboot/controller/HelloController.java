package cn.itcast.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
    public String index() {
        return "forward:/login";
    }
	
	@RequestMapping(value = "/login")
	String login(Model model) {
		model.addAttribute("TEST", "haha");
		logger.debug(JSON.toJSONString(model));
		return "login";
	}

	@RequestMapping("/home")
	@PreAuthorize("hasRole('USER')")
	String test(String user, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("message", username);
		return "index";
	}
}
