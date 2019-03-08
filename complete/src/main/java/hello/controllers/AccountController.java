package hello.controllers;

import hello.database.entities.AccountEntity;
import hello.database.entities.ListEntity;
import hello.database.repository.AccountRepository;
import hello.modelo.AccountUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;


    @PostMapping("/addToList")
    public void updateAccount(@RequestBody AccountUpdateRequest accountUpdateRequest){
        AccountEntity accountEntity= accountRepository.findOneByUserName(accountUpdateRequest.getUserName());
        accountEntity.setPassword(accountUpdateRequest.getPassword());
        accountEntity.setDescription(accountUpdateRequest.getDescription());
        accountEntity.setEmail(accountUpdateRequest.getEmail());
        accountEntity.setImage(accountUpdateRequest.getImage());
        accountRepository.save(accountEntity);

    }


//    para borrar accountrepository.delete(account entity)
}