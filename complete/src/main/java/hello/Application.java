package hello;

import hello.API.Anime;
import hello.API.SearchManager;
import hello.database.entities.AccountEntity;
import hello.database.entities.SeriesEntity;
import hello.database.repository.AccountRepository;
import hello.database.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ComponentScan
@SpringBootApplication
public class Application {

    @Autowired
    AccountRepository repository;
    @Autowired
    SeriesRepository seriesRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void prueba() throws Exception {

        SearchManager serch = new SearchManager();
        ArrayList<Anime> datos = serch.getAllAnimes();
        for(Anime anime:datos){
            System.out.println(anime.getData().getAttributes().getCanonicalTitle());
            SeriesEntity seriesEntity= new SeriesEntity();
            seriesEntity.setAgeRatinkg(anime.getData().getAttributes().getAgeRating());
            seriesEntity.setNombre(anime.getData().getAttributes().getCanonicalTitle());
            seriesEntity.setStatus(anime.getData().getAttributes().getStatus());
            seriesEntity.setShowType(anime.getData().getAttributes().getShowType());
            seriesRepository.save(seriesEntity);

        }
        List<SeriesEntity> ratingR = seriesRepository.findByAgeRatinkgAndShowType("R","movie");
        for( SeriesEntity s: ratingR)
        {
            System.out.println(s.getNombre());
        }


        for(int i=0; i<10;i++){
            AccountEntity datosUsuario = new AccountEntity();

            datosUsuario.setDescription("algo"+i);
            datosUsuario.setEmail("email@email"+i);
            datosUsuario.setPassword("cosoo"+i);
            datosUsuario.setUserName("Oscar"+i);
            repository.save(datosUsuario);
        }
        AccountEntity pruebita = repository.findOneById(13L);
        System.out.println(pruebita.getUserName());
    }
}
