package pt.iscte.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.nio.file.Paths;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		SpringApplication.run(HospitalApplication.class, args);
	}

}
 