package pt.iscte.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);

		// TODO Run thread de marcar slots

		// TODO Run thread de gestão da lista de espera para marcação de consulta

		// TODO Run thread de lista de espera (chamadas)

		// TODO Fechar todas as consultas que se encontrarem abertas ao final do dia (após 12? + tempo?)
	}

}
 