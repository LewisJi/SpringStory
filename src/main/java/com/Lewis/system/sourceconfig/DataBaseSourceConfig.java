package com.Lewis.system.sourceconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

public class DataBaseSourceConfig {
    protected Environment env;

    public DataBaseSourceConfig(Environment env) { this.env = env; }

    @Bean
    public LocalContainerEntityManagerFactoryBean dbEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("ods.jpa.properties.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("mssql.dialect"));

        em.setDataSource(dbDataSource());
        em.setPackagesToScan("com.Lewis.system.entity");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource dbDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("ods.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("ods.datasource.url"));
        dataSource.setUsername(env.getProperty("ods.datasource.username"));
        dataSource.setPassword(env.getProperty("ods.datasource.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(dbEntityManager().getObject());
        return transactionManager;
    }
}

