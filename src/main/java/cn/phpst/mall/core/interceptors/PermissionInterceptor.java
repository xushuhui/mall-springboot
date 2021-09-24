package cn.phpst.mall.core.interceptors;

import cn.phpst.mall.core.LocalUser;
import cn.phpst.mall.exception.http.ForbiddenException;
import cn.phpst.mall.exception.http.UnAuthenticatedException;
import cn.phpst.mall.model.User;
import cn.phpst.mall.service.UserSevice;
import cn.phpst.mall.util.JwtToken;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserSevice userSevice;

    public PermissionInterceptor() {
        super();
    }

    private Optional<ScopeLevel> getScopeLeve(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            if (scopeLevel == null) {
                return Optional.empty();
            }
            return Optional.of(scopeLevel);
        }
        return Optional.empty();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = getScopeLeve(handler);
        if (!scopeLevel.isPresent()) {
            return true;
        }
        String beartoken = request.getHeader("Authorization");
        if (StringUtils.isEmpty(beartoken)) {
            throw new UnAuthenticatedException(10004);
        }
        if (!beartoken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        String tokens[] = beartoken.split(" ");
        if (!(tokens.length == 2)) {
            throw new UnAuthenticatedException(10004);
        }
        String token = tokens[1];
        Optional<Map<String, Claim>> optionalMap = JwtToken.getClaims(token);
        Map<String, Claim> map = optionalMap.orElseThrow(() -> new UnAuthenticatedException(10004));

        boolean valid = this.hasPermission(scopeLevel.get(), map);
        if (valid) {
            setToThreadLocal(map);
        }
        return valid;
    }

    private void setToThreadLocal(Map<String, Claim> map) {
        Long uid = map.get("uid").asLong();
        Integer scope = map.get("scope").asInt();
        User user = userSevice.getUserById(uid);
        LocalUser.set(user, scope);
    }

    private boolean hasPermission(ScopeLevel scopeLevel, Map<String, Claim> map) {
        Integer level = scopeLevel.value();
        Integer scope = map.get("scope").asInt();
        if (level > scope) {
            throw new ForbiddenException(10005);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
