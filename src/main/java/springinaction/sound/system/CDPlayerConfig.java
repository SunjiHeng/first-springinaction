package springinaction.sound.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile ("dev")
@Configuration
//@ComponentScan(basePackageClasses = CompactDisc.class)
public class CDPlayerConfig {


    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers ();
    }
}
