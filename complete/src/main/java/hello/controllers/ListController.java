package hello.controllers;

import hello.database.entities.ListEntity;
import hello.database.entities.SeriesEntity;
import hello.database.repository.ListRepository;
import hello.modelo.ListCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/list")
public class ListController {
    @Autowired
    ListRepository listRepository;


    @PostMapping("/addToList")
    public ResponseEntity<String> addToList(@RequestBody ListCreateRequest listCreateRequest){
        ListEntity listEntity= new ListEntity();
        if(listCreateRequest.getPorVer()){
            if(listRepository.findFirstByIdAccountAndIdSerie(listCreateRequest.getIdAccount(),listCreateRequest.getIdSerie())==null){
                listEntity.setFavorito(listCreateRequest.getFavorito());
                listEntity.setIdAccount(listCreateRequest.getIdAccount());
                listEntity.setIdSerie(listCreateRequest.getIdSerie());
                listEntity.setPorVer(listCreateRequest.getPorVer());
                listEntity.setRank(listCreateRequest.getRank());
                listEntity.setVisto(listCreateRequest.getVisto());
                listRepository.save(listEntity);
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(listCreateRequest.getFavorito()) {
            if (listRepository.findFirstByIdAccountAndIdSerieAndVisto(listCreateRequest.getIdAccount(), listCreateRequest.getIdSerie(), listCreateRequest.getVisto()) != null) {
                listEntity.setFavorito(listCreateRequest.getFavorito());
                listEntity.setIdAccount(listCreateRequest.getIdAccount());
                listEntity.setIdSerie(listCreateRequest.getIdSerie());
                listEntity.setPorVer(listCreateRequest.getPorVer());
                listEntity.setRank(listCreateRequest.getRank());
                listEntity.setVisto(listCreateRequest.getVisto());
                listRepository.delete(listRepository.findFirstByIdAccount(listCreateRequest.getIdAccount()));
                listRepository.save(listEntity);
                return new ResponseEntity<>("", HttpStatus.OK);
            } else
                return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(listCreateRequest.getVisto()){
            if(listCreateRequest.getRank()!=0){
                listEntity.setFavorito(listCreateRequest.getFavorito());
                listEntity.setIdAccount(listCreateRequest.getIdAccount());
                listEntity.setIdSerie(listCreateRequest.getIdSerie());
                listEntity.setPorVer(listCreateRequest.getPorVer());
                listEntity.setRank(listCreateRequest.getRank());
                listEntity.setVisto(listCreateRequest.getVisto());
                listRepository.save(listEntity);
                return new ResponseEntity<>("", HttpStatus.OK);
            } else
                return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/search")
    public List<ListEntity> search(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{

        return listRepository.findByIdAccount(idAccount);
    }
    @GetMapping("/searchFavorite")
    public List<ListEntity> searchFavorite(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{
        return listRepository.findByIdAccountAndFavorito(idAccount,true);
    }
    @GetMapping("/searchSeen")
    public List<ListEntity> searchSeen(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{
        return listRepository.findByIdAccountAndVisto(idAccount,true);
    }
    @GetMapping("/searchForWatch")
    public List<ListEntity> searchForWatch(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{
        return listRepository.findByIdAccountAndPorVer(idAccount,true);
    }

    @PostMapping("/delete")
    public void deleteAccount(@RequestParam Long idAccount){
        ListEntity accountEntity = listRepository.findFirstByIdAccount(idAccount);
        listRepository.delete(accountEntity);
    }


}
