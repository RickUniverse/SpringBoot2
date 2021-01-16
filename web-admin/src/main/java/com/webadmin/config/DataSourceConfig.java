package com.webadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/14 - 20:22
 */
@Deprecated
//@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setFilters("stat,wall");// 开启sql监控
        return new DruidDataSource();
    }

    /**
     * JDBC操作配置
     * @param dataSource
     * @return
     */
    /*@Bean(name = "dataOneTemplate")
    public JdbcTemplate jdbcTemplate (@Autowired DruidDataSource dataSource){
        return new JdbcTemplate(dataSource) ;
    }*/

    /**
     * 配置 Druid 监控界面
     * 配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean srb =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置控制台管理用户, 老师是使用的addInitParameter
        //srb.addInitParameter("loginUsername","root");
        //srb.addInitParameter("loginPassword","root");
        //是否可以重置数据。禁用HTML页面上的“Reset All”功能
        //srb.addInitParameter("resetEnable","false");

        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","root");
        initParams.put("loginPassword","root");
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","192.168.1.110");// 拒绝本机访问
        initParams.put("","");
        initParams.put("","");

        srb.setInitParameters(initParams);

        return srb;
    }

    // WebStatFilter 用于采集web-jdbc关联监控的数据
    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器
        FilterRegistrationBean frb =
                new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        frb.addUrlPatterns("/*");
        //忽略过滤的形式
        frb.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return frb;
    }

}
