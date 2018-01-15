package springinaction.mvc.basic;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

/**
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("springinaction")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器
     *
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

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource ();
        messageSource.setBasename ("messages");

        //another way ---


        return messageSource;
    }


    /**
     * 配置tiles视图解析器
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer ();
        tiles.setDefinitions (new String[]{
                "/WEB-INF/layout/tiles.xml"
        });//指定tile定义的位置
        tiles.setCheckRefresh (true);//刷新功能
        return tiles;

    }

    @Bean
    public ViewResolver tilesViewResolver() {
        return new TilesViewResolver ();
    }



    //配置thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver ();
        templateResolver.setPrefix ("/WEB-INF/views");
        templateResolver.setSuffix (".html");
        templateResolver.setTemplateMode ("HTML");
        templateResolver.setCacheable (false);
        templateResolver.setCharacterEncoding ("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine ();
        templateEngine.setTemplateResolver (templateResolver);
        return templateEngine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        //http://blog.csdn.net/vili_sky/article/details/78552915?locationNum=5&fps=1
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver ();
        return viewResolver;
    }



}
