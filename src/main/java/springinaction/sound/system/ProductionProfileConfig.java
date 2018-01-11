package springinaction.sound.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
@Profile ("prod")
public class ProductionProfileConfig {

    @Bean

    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean ();
        jndiObjectFactoryBean.setJndiName ("jdbc");
        return ((DataSource) jndiObjectFactoryBean.getObject ());

    }
}
