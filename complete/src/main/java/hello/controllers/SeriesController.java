package hello.controllers;

import hello.database.entities.SeriesEntity;
import hello.database.repository.ListRepository;
import hello.database.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/series")
public class SeriesController {

    @Autowired
    SeriesRepository seriesRepository;

    @GetMapping("/search")
    public List<SeriesEntity> search(@RequestParam(value = "showType",required = false) String showType,
                                     @RequestParam(value = "status",required = false) String status,
                                     @RequestParam(value = "ageRating",required = false) String ageRating)throws  Exception{



    if(showType!= null && status== null && ageRating== null)
        return seriesRepository.findByShowType(showType);
    return null;
    }

}
