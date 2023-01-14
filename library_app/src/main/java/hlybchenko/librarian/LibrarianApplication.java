package hlybchenko.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class LibrarianApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarianApplication.class, args);

        System.out.println("Open in browser (default): http://localhost:8080/");
    }

}