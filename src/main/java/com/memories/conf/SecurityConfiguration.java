package com.memories.conf;

import com.memories.security.MemoriesRestAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private final String userQuery = "SELECT login, password, TRUE "
            + "FROM users "
            + "WHERE login = ?";

    private final String authoritiesQuery = "select login, role_of_user " +
            " from users where login = ?;";

    /**
     * This section defines the user accounts which can be used for
     * authentication as well as the roles each user has.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(authoritiesQuery);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/css/**", "/fonts/**", "/image/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginProcessingUrl("/login").permitAll()
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .successHandler(new MemoriesRestAuthenticationSuccessHandler())
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                    .logout()
                    .logoutUrl("/logout");
        // Basic authorization off
//                .and()
//                    .httpBasic()
//                    .authenticationEntryPoint(new MemoriesRestAuthenticationEntryPoint());
    }
}
