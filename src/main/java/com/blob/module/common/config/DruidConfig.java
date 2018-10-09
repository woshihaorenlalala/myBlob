package com.blob.module.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


/**
 * Created by cc on 2018/9/27.
 */
@Configuration
public class DruidConfig {

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServlet2() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
//登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin2");
        servletRegistrationBean.addInitParameter("loginPassword", "1234");
//是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }
    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
//添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
//添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
        return filterRegistrationBean;
    }

    @Bean
    public DruidDataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                           @Value("${spring.datasource.url}") String url,
                                           @Value("${spring.datasource.username}") String username,
                                           @Value("${spring.datasource.password}") String password,
                                           @Value("${spring.datasource.maxActive}") int maxActive
    ){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maxActive);

        System.out.println("DruidConfiguration.druidDataSource(),url = [" + url + "], username = [" + username + "], password = [" + password + "], maxActive = [" + maxActive + "]");

        try {
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
