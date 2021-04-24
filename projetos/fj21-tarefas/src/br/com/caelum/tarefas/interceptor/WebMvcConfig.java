package br.com.caelum.tarefas.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
            .addInterceptor(new AutorizadorInterceptor() {
         
            }).order(Ordered.HIGHEST_PRECEDENCE);
    }

}

