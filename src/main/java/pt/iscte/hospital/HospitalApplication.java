package pt.iscte.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);

		// Run thread de marcar slots

		// Run thread de gestão da lista de espera para marcação de consulta

		// Run thread de lista de espera (chamadas)
	}

}
 