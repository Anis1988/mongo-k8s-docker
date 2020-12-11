package com.anis.mongodbboot.controller;

import com.anis.mongodbboot.document.Users;
import com.anis.mongodbboot.service.UsersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reset/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsersController  {

    private final UsersServices usersServices;

    @GetMapping("/all")
    public List<Users> getALl(){
        return usersServices.getThem();
    }
    @GetMapping("/{name}")
    public Users getOne(@PathVariable("name") String name){
      return usersServices.getOne(name);
    }
    @DeleteMapping("/delete/{name}")
    public void delete (@PathVariable("name") String name ){
        usersServices.remove(name);
    }
    @PostMapping
    public Users insert(@RequestBody @Valid Users users){
        return usersServices.add(users);
    }
    @PutMapping("/update/{name}")
    public Users update(@PathVariable("name") String name,@Valid @RequestBody Users users) {
        return usersServices.update(name,users);
    }
    @GetMapping("/byteamName")
    public List<Users> getThemByTeam(@RequestParam(required = false) String teamName){
        return usersServices.getThemByTeamName(teamName);
    }
}
