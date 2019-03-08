package hello.controllers;

import hello.database.entities.AccountEntity;
import hello.database.entities.ListEntity;
import hello.database.repository.AccountRepository;
import hello.modelo.AccountCreateRequest;
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


    @PostMapping("/update")
    public void updateAccount(@RequestBody AccountUpdateRequest accountUpdateRequest){
        AccountEntity accountEntity= accountRepository.findOneByUserName(accountUpdateRequest.getUserName());
        accountEntity.setPassword(accountUpdateRequest.getPassword());
        accountEntity.setDescription(accountUpdateRequest.getDescription());
        accountEntity.setEmail(accountUpdateRequest.getEmail());
        accountEntity.setImage(accountUpdateRequest.getImage());
        accountRepository.save(accountEntity);
    }
    @PostMapping("/create")
    public void createAccount(@RequestBody AccountCreateRequest accountcreateRequest){
        AccountEntity accountEntity= new AccountEntity();
        accountEntity.setUserName(accountcreateRequest.getUserName());
        accountEntity.setPassword(accountcreateRequest.getPassword());
        accountEntity.setDescription(accountcreateRequest.getDescription());
        accountEntity.setEmail(accountcreateRequest.getEmail());
        accountEntity.setImage(accountcreateRequest.getImage());
        accountRepository.save(accountEntity);
    }

    @PostMapping("/delete")
    public void deleteAccount(@RequestParam Long idAccount){
        AccountEntity accountEntity = accountRepository.findOneById(idAccount);
        accountRepository.delete(accountEntity);
    }

    @GetMapping("/view")
    public AccountEntity view(@RequestParam(value = "idAccount",required = true) Long idAccount){
        return accountRepository.findOneById(idAccount);

    }

//    para borrar accountrepository.delete(account entity)
}