package spring_mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService; // сервис, с помощью которого тащим пользователя


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);  // конфигурация для прохождения аутентификации
//                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")  //Страница с формой
                .successHandler(new LoginSuccessHandler())
                .loginProcessingUrl("/login")   //url формы
                .usernameParameter("username")  //Параметры формы
                .passwordParameter("password")  //Параметры формы
                .permitAll();

        http
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .and().csrf().disable();  //разрыв соединения и инфорамации о пользователе

        http
                .authorizeRequests()
                .antMatchers("/login").anonymous() //Незалогиненный пользователь может посещать только страницу /login
                .antMatchers("/admin", "/admin/**")
                .hasAuthority("ROLE_ADMIN") //ADMIN может посещать страницы /admin/**
                .antMatchers("/hello")
                .hasAuthority("ROLE_USER"); //USER может посещать страницу /hello
    }

//                .access("hasAnyRole('ROLE_USER')")
//                .anyRequest().authenticated();


    // Необходимо для шифрования паролей
    // В данном примере не используется, отключен
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();  //Кодировка пароля
//    }
}