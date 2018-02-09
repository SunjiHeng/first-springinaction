package springinaction.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author HP
 * @create 2018-01-27-16:16
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests ()
//            .antMatchers ("/spitters/me")
//            .authenticated ()
//            .antMatchers (HttpMethod.POST, "/spittles")
//            .authenticated ()
//            .anyRequest ()
//            .permitAll ();

        http.formLogin ().loginPage ("/login").and ().rememberMe ().tokenValiditySeconds (2419200).key ("spittrKey")
            .and ()
            .authorizeRequests ()
            .antMatchers ("/spitter/me")
            .hasRole ("SPITTER")
            .antMatchers (HttpMethod.POST, "/spittles")
            .hasRole ("SPITTER")
            .anyRequest ()
            .permitAll ()
            .and ()
            .requiresChannel ()
            .antMatchers ("/spitter/form")
            .requiresSecure ()
            .and ()
            .httpBasic ().realmName ("Spittr");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication ()
//            .withUser ("user")
//            .password ("password")
//            .roles ("USER")
//            .and ()
//            .withUser ("admin")
//            .password ("password")
//            .roles ("USER", "ADMIN");

//        auth.jdbcAuthentication ()
//            .dataSource (dataSource)
//            .usersByUsernameQuery (
//                    "select username,password,true from Spitter where username=?"
//            )
//            .authoritiesByUsernameQuery (
//                    "select username,'ROLE_USER' from Spitter where username=?"
//            );

        auth.jdbcAuthentication ()
            .dataSource (dataSource)
            .usersByUsernameQuery (
                    "select username,password,true from Spitter where username=?"
            )
            .authoritiesByUsernameQuery (
                    "select username,'ROLE_USER' from Spitter where username=?"
            )
            .passwordEncoder (new StandardPasswordEncoder ("53cr3t"));

        auth.ldapAuthentication ()
            .userSearchFilter ("(uid={0})")
            .groupSearchFilter ("member={0}");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure (web);
    }
}
