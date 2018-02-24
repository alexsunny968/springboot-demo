package cn.unisolution.demo.interceptor;

import cn.unisolution.demo.interfacer.Access;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/2/24.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Access access = method.getAnnotation(Access.class);

        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }

        if (access.authorities().length > 0) {
            String[] authorities = access.authorities();
            Set<String> authSet = new HashSet<>();

            for (String authority : authorities) {
                authSet.add(authority);
            }

            String role = request.getParameter("role");
            if (!StringUtils.isEmpty(role)) {
                if (authSet.contains(role)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
