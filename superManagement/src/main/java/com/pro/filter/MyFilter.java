package com.pro.filter;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "myFilter" , urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        int sum = 0;
        if (cookies==null){
            login("/");
        }else {
            for (Cookie cookie : cookies) {
                if ("identity".equals(cookie.getName())){
                    sum++;
                }
            }
            if (sum == 0){
                login("/");
            }
        }


    }

    @Override
    public void destroy() {

    }

    public static ModelAndView login(String url){
        return new ModelAndView(url);
    }
}
