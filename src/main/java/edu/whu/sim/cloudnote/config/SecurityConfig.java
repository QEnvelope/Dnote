package edu.whu.sim.cloudnote.config;

import edu.whu.sim.cloudnote.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private static final String KEY = "qyyyy";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 配置用户的验证方式
     * @return
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setHideUserNotFoundExceptions(false);
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder); // 设置密码加密方式
        return authenticationProvider;
    }

    /**
     * 自定义配置登录的策略
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/img/**", "/css/**", "/js/**", "/fonts/**", "/register").permitAll() // 都可以访问
                .and()
                .formLogin()   //基于 Form 表单登录验证
                .loginPage("/login")
                .successHandler(loginSuccessHandler())
//                .failureHandler(myAuthenticationFailHandler)
                .failureUrl("/login-error")// 自定义登录界面
                .permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
//                .and().exceptionHandling().accessDeniedPage("/403")  // 处理异常，拒绝访问就重定向到 403 页面
                .and().logout().logoutUrl("/logout").permitAll().invalidateHttpSession(true).permitAll();

        http.csrf().disable();  //禁用csrf防御
        http.sessionManagement().invalidSessionUrl("/login");  //session失效重新跳转登录
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);   //只允许一个用户登录
        http.headers().frameOptions().disable(); //把当前字段禁用


    }

    /**
     * 配置用户验证方式
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.eraseCredentials(false);
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }

//    /**
//     * 登出处理方法
//     * @return
//     */
//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
//        return new LogoutSuccessHandler() {
//            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                try {
//                    User user = (User) authentication.getPrincipal();
////                    logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
//                } catch (Exception e) {
////                    logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
//                }
//                httpServletResponse.sendRedirect("/login");
//            }
//        };
//    }

    /**
     * 登录成功处理方法
     * @return
     */
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User user = (User) authentication.getPrincipal();
                logger.info("USER : " + user.getId() + ": " + user.getUsername() + " LOGIN SUCCESS !  ");
                response.sendRedirect("/note/notes/");  //指定重定向页面
//                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }
}
