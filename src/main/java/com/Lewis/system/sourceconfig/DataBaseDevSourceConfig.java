package com.Lewis.system.sourceconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("dev")
@Configuration
@EnableJpaRepositories(basePackages = "com.Lewis.system.sourceconfig",
        entityManagerFactoryRef = "dbEntityManager",
        transactionManagerRef = "dbTransactionManager")
public class DataBaseDevSourceConfig extends DataBaseSourceConfig {

    @Autowired
    public DataBaseDevSourceConfig(Environment env) { super(env); }

}
