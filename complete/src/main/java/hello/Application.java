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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@SpringBootApplication
@EnableWebMvc
public class Application {

    @Autowired
    AccountRepository repository;
    @Autowired
    SeriesRepository seriesRepository;
    SearchManager serch = new SearchManager();
    static ArrayList<Anime> datos = new ArrayList<Anime>();


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void prueba() throws Exception {

        datos = serch.getAllAnimes();
        for(Anime anime:datos){
//            System.out.println(anime.getData().getAttributes().getCanonicalTitle());
            SeriesEntity seriesEntity= new SeriesEntity();
            seriesEntity.setAgeRatinkg(anime.getData().getAttributes().getAgeRating());
            seriesEntity.setNombre(anime.getData().getAttributes().getCanonicalTitle());
            seriesEntity.setStatus(anime.getData().getAttributes().getStatus());
            seriesEntity.setShowType(anime.getData().getAttributes().getShowType());
            seriesRepository.save(seriesEntity);
        }
//        List<SeriesEntity> ratingR = seriesRepository.findByAgeRatingAndShowType("R","movie");
//        for( SeriesEntity s: ratingR)
//        {
//            System.out.println(s.getNombre());
//        }
        for(int i=0; i<10;i++){
            AccountEntity datosUsuario = new AccountEntity();
            datosUsuario.setDescription("algo"+i);
            datosUsuario.setEmail("email@email"+i);
            datosUsuario.setPassword("cosoo"+i);
            datosUsuario.setUserName("Julio"+i);
            repository.save(datosUsuario);
        }
//
//        System.out.println(pruebita.getUserName());
    }
}
