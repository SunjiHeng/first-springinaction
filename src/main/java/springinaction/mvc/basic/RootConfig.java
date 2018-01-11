package springinaction.mvc.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author HP
 * @create 2018-一月-09-9:49
 */
@Configuration
@ComponentScan(basePackages = {"springinaction"},
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class RootConfig {
}
