package com.itech.bookstore.interceptor;

import com.itech.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckAdminPermissionsInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(CheckAdminPermissionsInterceptor.class);

    @Autowired
    private UserService userServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof HandlerMethod) {
            CheckAdminPermissions checkAdminPermissions = ((HandlerMethod) handler).getMethodAnnotation(
                CheckAdminPermissions.class);
            if (null == checkAdminPermissions) {
                checkAdminPermissions = ((HandlerMethod) handler).getMethod().getDeclaringClass()
                    .getAnnotation(CheckAdminPermissions.class);
            }
            // Check permissions of the user
            if (null != checkAdminPermissions) {
                String user = request.getHeader("X-User");
                logger.debug("User {} trying to access admin endpoint", user);
                return userServiceImpl.hasPermissions(user, "admin");
            }
        }
        return true;
    }

    @Override
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        @Nullable
            ModelAndView modelAndView
    ) {
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        @Nullable
            Exception ex
    ) {
    }
}