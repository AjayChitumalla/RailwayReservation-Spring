package com.org.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.org.controller")
@EnableJpaRepositories(basePackages = {"com.org.repository"})
@EnableTransactionManagement
public class ApplicationConfig implements WebMvcConfigurer{
	
	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.org.bean" });

	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());

	      return em;
	   }
	   
	   @Bean
	   public DataSource dataSource(){
		   
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	       dataSource.setUrl("jdbc:mysql://localhost:3306/reservation");
	       dataSource.setUsername( "root" );
	       dataSource.setPassword( "ajayCh" );
	       return dataSource;
	   }
	   
	   @Bean
	   public PlatformTransactionManager transactionManager() {
		   
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	       return transactionManager;
	   }
	   Properties additionalProperties() {
		   
	       Properties properties = new Properties();
	       properties.setProperty("hibernate.hbm2ddl.auto", "update");
	       properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	       properties.setProperty("hibernate.show_sql", "true");
	       properties.setProperty("hibernate.format_sql", "true");
	          
	       return properties;
	   }
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
