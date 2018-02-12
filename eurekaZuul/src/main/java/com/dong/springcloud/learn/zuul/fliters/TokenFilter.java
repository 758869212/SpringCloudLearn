package com.dong.springcloud.learn.zuul.fliters;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @user Dong.
 * @date 2018-01-13 22：59
 */
@Component
public class TokenFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest = ctx.getRequest();
		String url = httpServletRequest.getRequestURI();
		if (url.contains("/token/")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest = ctx.getRequest();
		String token = httpServletRequest.getParameter("token");
		if (StringUtils.isNotBlank(token)) {
		} else {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is Empty!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
