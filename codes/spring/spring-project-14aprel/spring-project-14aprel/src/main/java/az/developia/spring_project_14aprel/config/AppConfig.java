package az.developia.spring_project_14aprel.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	private Logger log = LoggerFactory.getLogger(AppConfig.class);
			
	public void test() {
		log.trace("bütün melumatlar ucun");
		log.debug("developer ucun logging");
		log.info("sistem melumatları ucun");
		log.warn("xeberdarlıq ucun");
		log.error("xetalar ucun");
		
	}
   
}