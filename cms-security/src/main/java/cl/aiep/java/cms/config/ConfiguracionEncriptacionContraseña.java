package cl.aiep.java.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracionEncriptacionContraseĆ±a {
	@Bean
	
	public PasswordEncoder codificadorDeContraseĆ±as() 
	{
		return new BCryptPasswordEncoder();
	}

}
