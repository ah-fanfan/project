package com.cxsw.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	public static void addCookie(HttpServletResponse response, String name, String value) {
		String urlName;
		try {
			urlName = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			urlName = value;
		}
		Cookie cookie = new Cookie(name, urlName);
		cookie.setPath("/");
		cookie.setMaxAge(10 * 24 * 60 * 60);
		response.addCookie(cookie);
	}
}
