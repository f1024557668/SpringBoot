package cn.itcast.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常捕获处理
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		// 打印异常信息：
		System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
		ModelAndView mv = new ModelAndView("/error");
		mv.addObject("e", e);
		mv.addObject("uri", req.getRequestURI());
		return mv;
	}
}
