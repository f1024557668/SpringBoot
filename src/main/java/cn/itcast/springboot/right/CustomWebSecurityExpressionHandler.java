package cn.itcast.springboot.right;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;


public class CustomWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
	@Override
	public void setPermissionEvaluator(PermissionEvaluator permissionEvaluator) {
		super.setPermissionEvaluator(permissionEvaluator);
	}
}
