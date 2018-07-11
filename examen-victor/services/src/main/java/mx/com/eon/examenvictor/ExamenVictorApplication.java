package mx.com.eon.examenvictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableHystrix
//@EnableSwagger2
@ComponentScan(basePackages="mx.com.eon")
@EnableJpaRepositories(basePackages="mx.com.eon.persistence.repository")
@EntityScan(basePackages="mx.com.eon.model")
public class ExamenVictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenVictorApplication.class, args);
	}
}
