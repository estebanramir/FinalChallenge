package hello.controllers;

import hello.database.entities.ListEntity;
import hello.database.entities.SeriesEntity;
import hello.database.repository.ListRepository;
import hello.modelo.ListCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addToList(@RequestBody ListCreateRequest listCreateRequest){
        ListEntity listEntity= new ListEntity();
        listEntity.setFavorito(listCreateRequest.getFavorito());
        listEntity.setIdAccount(listCreateRequest.getIdAccount());
        listEntity.setIdSerie(listCreateRequest.getIdSerie());
        listEntity.setPorVer(listCreateRequest.getPorVer());
        listEntity.setRank(listCreateRequest.getRank());
        listEntity.setVisto(listCreateRequest.getVisto());
        listRepository.save(listEntity);
            return "";
    }




    @GetMapping("/search")
    public List<ListEntity> search(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{

        return listRepository.findByIdAccount(idAccount);
    }
    @GetMapping("/searchFavorite")
    public List<ListEntity> searchFavorite(@RequestParam(value = "idAccount",required = true) Long idAccount)throws  Exception{

        return listRepository.findByIdAccountAndFavorito(idAccount,true);
    }


}
