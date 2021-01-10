package com.yll.eduservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 颜起名
 * @create date 2020-09-04-19:37
 */
//@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置 Druid 的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        map.put("allow", "localhost");       //不写 或者为null 默认允许所有
        map.put("deny", "192.168.1.122");
        bean.setInitParameters(map);
        return bean;
    }

    //2.配置一个监控的Filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean initParam = new FilterRegistrationBean();
        initParam.setFilter(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        //初始化不拦截请求的参数
        map.put("exclusions", "*.css,*.png,*.jpg,*.js,/druid/*");
        initParam.setInitParameters(map);
        return initParam;
    }
}
