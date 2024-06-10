/* package muvie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import muvie.principal.Principal;
import muvie.repository.SerieRepository;

@SpringBootApplication
public class Consola implements CommandLineRunner {

	@Autowired

	private SerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Consola.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
*/