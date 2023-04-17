package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		loadEnvVariables();
		SpringApplication.run(ApiApplication.class, args);
	}

	private static void loadEnvVariables() {
		// Carrega as variáveis do arquivo ".env"
		Properties props = new Properties();
		try (InputStream input = new FileInputStream(".env")) {
			props.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		props.forEach((key, value) -> {
			System.setProperty((String) key, (String) value);
		});
	}

}
