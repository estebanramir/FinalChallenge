package hello;

import hello.database.entities.AccountEntity;
import hello.database.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@ComponentScan
@SpringBootApplication
public class Application {

    @Autowired
    AccountRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void prueba(){


        for(int i=0; i<10;i++){
            AccountEntity datosUsuario = new AccountEntity();
            datosUsuario.setDescription("algo"+i);
            datosUsuario.setEmail("email@email"+i);
            datosUsuario.setPassword("cosoo"+i);
            datosUsuario.setUserName("Oscar"+i);
            repository.save(datosUsuario);
        }
    }
}
