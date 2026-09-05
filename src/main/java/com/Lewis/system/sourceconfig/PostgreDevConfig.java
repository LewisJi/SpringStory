package com.Lewis.system.sourceconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.Lewis.system.sourceconfig.EnvDefine.PROFILE_DEV;

@Profile(PROFILE_DEV)
@Configuration
@EnableJpaRepositories(basePackages = "com.Lewis.**.repository",
        entityManagerFactoryRef = "pgreEntityManager",
        transactionManagerRef = "pgreTransactionManager")
public class PostgreDevConfig extends  PostgreConfig{

    @Autowired
    public PostgreDevConfig(Environment env) {
        super(env);
    }
}
