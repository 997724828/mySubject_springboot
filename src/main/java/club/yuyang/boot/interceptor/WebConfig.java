package club.yuyang.boot.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/26 11:39
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        String[] excludes = new String[]{"/","/out","/static/**","/index"};
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns(excludes);
    }


}
