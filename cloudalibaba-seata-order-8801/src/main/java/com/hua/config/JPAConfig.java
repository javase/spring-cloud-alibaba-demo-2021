package com.hua.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = {"com.hua.dao.repository"})
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {DruidDataSourceAutoConfigure.class})
public class JPAConfig {
	@Value("${spring.datasource.druid.url}")
	private String dbUrl;

	@Value("${spring.datasource.druid.username}")
	private String dbUserName;

	@Value("${spring.datasource.druid.password}")
	private String dbPassword;


	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.hua.dao.entity");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Primary
	@Bean(name = "transactionManager")
	public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory.getObject());
		return manager;
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = (DruidDataSource) getDataSource();
		return dataSource;
	}

	private DataSource getDataSource() {
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);

		dataSource.setInitialSize(2);
		dataSource.setMinIdle(1);
		dataSource.setUseUnfairLock(true);

		dataSource.setMinEvictableIdleTimeMillis(10 * 60 * 1000L);
		dataSource.setMaxEvictableIdleTimeMillis(15 * 60 * 1000);
		dataSource.setTimeBetweenEvictionRunsMillis(2 * 1000);

		dataSource.setValidationQuery("SELECT 'x'");
		dataSource.setTestWhileIdle(true);
		dataSource.setKeepAlive(true);
		dataSource.setPhyMaxUseCount(500);
		try {
			dataSource.setFilters("stat");
			dataSource.setDbType("mysql");
			dataSource.setFilters("wall");
		}
		catch (Exception ex) {
			log.error("druid配置异常", ex);
		}
		return dataSource;
	}




	@Bean("namedJdbcTemplate")
	public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
