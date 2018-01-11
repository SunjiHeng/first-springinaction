package springinaction.mvc.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("springinaction")
public class WebConfig extends WebMvcConfigurerAdapter{
    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver ();
        resolver.setPrefix ("/WEB-INF/views/");
        resolver.setSuffix (".jsp");
        resolver.setExposeContextBeansAsAttributes (true);
        //将视图解析为jstlView,而不是InternalResourceView，用于本地化-国际化
        resolver.setViewClass (JstlView.class);
        return resolver;
    }

    /**
     * 配置静态资源处理，
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //要求前端控制器将静态资源的请求转发到Servlet容器中默认的Servlet上，而不是前端控制器处理
        configurer.enable ();
    }
}
