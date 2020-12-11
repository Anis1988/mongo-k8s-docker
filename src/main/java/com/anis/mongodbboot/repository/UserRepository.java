package com.anis.mongodbboot.repository;


import com.anis.mongodbboot.document.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,String> {

    Users findByName(String name);

//    List<Users> findBySalary(Optional<Integer> salary);
}
