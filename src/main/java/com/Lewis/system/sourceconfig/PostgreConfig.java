package com.Lewis.system.sourceconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

public class PostgreConfig {
    protected Environment env;

    public PostgreConfig(Environment env) { this.env = env; }

    @Bean
    public LocalContainerEntityManagerFactoryBean pgreEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("pgre.jpa.properties.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("postgre.dialect", "org.hibernate.dialect.PostgreSQLDialect"));

        em.setDataSource(pgreDataSource());
        em.setPackagesToScan("com.Lewis.**.model");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource pgreDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 這些屬性值需要在 application.properties 或 application.yml 中設定為 PostgreSQL 的連線資訊
        dataSource.setDriverClassName(env.getProperty("pgre.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("pgre.datasource.url"));
        dataSource.setUsername(env.getProperty("pgre.datasource.username"));
        dataSource.setPassword(env.getProperty("pgre.datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager pgreTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // 修正：改用引數注入（Dependency Injection），避免直接呼叫方法導致 Bean 重複建立
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
