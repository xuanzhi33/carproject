package cn.xuanzhi33.carprojectserver.interceptors;

import cn.xuanzhi33.carprojectserver.exception.UnauthorizedException;
import cn.xuanzhi33.carprojectserver.util.Hmac;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Value("${carproject.hmac-key}")
    private String hmacKey;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler
    ) throws Exception {
        String method = request.getMethod();
        if (method.equals("OPTIONS")) {
            return true;
        }

        String username = request.getHeader("Xuanzhi33-User");
        String token = request.getHeader("Xuanzhi33-Token");
        if ((!StringUtils.hasLength(username)) || (!StringUtils.hasLength(token))) {
            throw new UnauthorizedException("Unauthorized");
        }

        if (Hmac.verifyHMAC(username, hmacKey, token)) {
            return true;
        } else {
            throw new UnauthorizedException("Token is invalid");
        }
    }
}