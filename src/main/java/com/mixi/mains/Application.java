package com.mixi.mains;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.mixi.mains.mapper")
public class Application {

  private static Logger logger = Logger.getLogger(Application.class);


  // 默认入口
  @RequestMapping(value = "/")
  String home() {
    return "hello world";
  }

  // DataSource配置
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return new DataSource();
  }

  // 提供sqlSeesion
  @Bean
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
 
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  /**
   * @Description 主函数，main方法
   * @author taohanlin
   * @date 2016年6月2日 下午6:03:38
   * @action main
   * @return void
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    logger.info("==================springboot start success=====================");
  }


}
