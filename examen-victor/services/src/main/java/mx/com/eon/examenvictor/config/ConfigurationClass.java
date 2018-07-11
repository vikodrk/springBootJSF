package mx.com.eon.examenvictor.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.eon.examenvictor.service.IFamiliarTypeService;
import mx.com.eon.examenvictor.service.IGeneralDataService;
import mx.com.eon.examenvictor.service.IUserTypeService;
import mx.com.eon.examenvictor.service.impl.FamiliarTypeServiceImpl;
import mx.com.eon.examenvictor.service.impl.GeneralDataServiceImpl;
import mx.com.eon.examenvictor.service.impl.UserTypeServiceImpl;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;
import mx.com.eon.persistence.dao.IGeneralDataDAO;
import mx.com.eon.persistence.dao.IUserTypeDAO;
import mx.com.eon.persistence.dao.impl.FamiliarTypeDAOImpl;
import mx.com.eon.persistence.dao.impl.GeneralDataDAOImpl;
import mx.com.eon.persistence.dao.impl.UserTypeDAOImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ConfigurationClass {
	
	@Bean
    public Docket newsApi() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("Examen")
            .apiInfo(apiInfo()).select().paths(regex("/*.*")).build();
    }
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("Examen Rest")
            .description("Ejercicio de Examen Victor Hugo")
            .termsOfServiceUrl("2code.com.mx")
            .license("GNU General Public License")
            .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html")
            .version("0.0.1-SNAPSHOT").build();
    }
	
	@Bean
	public IFamiliarTypeDAO familiarDAO() {
		return new FamiliarTypeDAOImpl();
	}
	
	@Bean
	public IFamiliarTypeService familiarService() {
		return new FamiliarTypeServiceImpl();
	}
	
	@Bean
	public IGeneralDataDAO generalDAO() {
		return new GeneralDataDAOImpl();
	}
	
	@Bean
	public IGeneralDataService generalService() {
		return new GeneralDataServiceImpl();
	}
	
	@Bean
	public IUserTypeDAO userTypeDAO() {
		return new UserTypeDAOImpl();
	}
	
	@Bean
	public IUserTypeService userTypeService() {
		return new UserTypeServiceImpl();
	}

}
