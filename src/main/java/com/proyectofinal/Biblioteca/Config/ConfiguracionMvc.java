package com.proyectofinal.Biblioteca.Config;

import com.proyectofinal.Biblioteca.Interceptor.TiempoEjecucionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionMvc implements WebMvcConfigurer {

    @Autowired
    private TiempoEjecucionInterceptor tiempoEjecucionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tiempoEjecucionInterceptor);
    }
}
