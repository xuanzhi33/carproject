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

import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Value("${carproject.hmac-key}")
    private String hmacKey;

    @Value("${carproject.allowlist}")
    private List<String> allowlist;

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

        if (!Hmac.verifyHMAC(username, hmacKey, token)) {
            throw new UnauthorizedException("Token is invalid");
        }

        if (!allowlist.contains(username)) {
            throw new UnauthorizedException("User is not allowed");
        }

        return true;
    }
}
