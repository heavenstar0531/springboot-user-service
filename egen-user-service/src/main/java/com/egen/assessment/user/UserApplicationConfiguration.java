package com.egen.assessment.user;

import javax.sql.DataSource;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Spring application context configuration for the User service.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@Configuration
@ComponentScan({
	"com.egen.assessment.user"
})
@PropertySource("classpath:properties/db-config.properties")
@EnableTransactionManagement
@EnableJpaRepositories("com.egen.assessment.user.domain")
@EntityScan("${entitymanager.packages.to.scan}")
public class UserApplicationConfiguration {

	/**
	 * Returns the data source for connecting to the persistent store.
	 *
	 * @return application data source
	 */
	@ConfigurationProperties("spring.datasource")
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}	
}
