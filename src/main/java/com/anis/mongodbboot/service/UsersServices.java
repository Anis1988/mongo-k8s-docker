package com.anis.mongodbboot.service;

import com.anis.mongodbboot.document.Address;
import com.anis.mongodbboot.document.Reviews;
import com.anis.mongodbboot.document.Users;
import com.anis.mongodbboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UsersServices {

    private final UserRepository userRepository;

    public List<Users> getThem(){
        return (List<Users>) userRepository.findAll();
    }
    public Users getOne(String name){
        Users byName = userRepository.findByName(name);
        if(byName ==  null) {
            Users users = new Users("XXXXXXX", "XXXXXXX", 0000000,
                    Arrays.asList(new Reviews("XXXXXXX", 0000000, false)),
                    new Address("XXXXXXX", "XXXXXXX"));
            users.setId("000000000");
            return users;
        }
        return byName;
    }
    public void remove(String name){
        Users name1 = userRepository.findByName(name);
        userRepository.delete(name1);
    }
    public Users add(Users users){
        return userRepository.save(users);
    }
    public Users update(String name,Users users){
        Users byName = userRepository.findByName(name);
        if(byName !=null){
            byName.setAddress(users.getAddress());
            byName.setName(users.getName());
            byName.setReviews(users.getReviews());
            byName.setSalary(users.getSalary());
            byName.setTeamName(users.getTeamName());
            userRepository.save(byName);
            return byName;
        }
        userRepository.save(users);
        return users;
    }
    public List<Users> getThemByTeamName(String teamName) {
        List<Users> userList =  (List<Users>) userRepository.findAll();
        if(teamName.isEmpty()){
            return userList;
        }
        else {
            return userList.stream()
                    .filter(users -> users.getTeamName().equals(teamName))
                    .collect(Collectors.toList());
        }
    }
}
