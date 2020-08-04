package sum3.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "sum3" },
    exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackages = "sum3.dao")
@EntityScan(basePackages = "sum3.dao.entity")
public class Sum3ApiApplication extends SpringBootServletInitializer{


	  public static void main(String[] args) {
	    SpringApplication.run(Sum3ApiApplication.class, args);
	  }

	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(Sum3ApiApplication.class);
	  }

	

	
}
