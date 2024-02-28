package com.generation.jamanjibackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.UserRepository;

@SpringBootTest
class TestJ {

    @Autowired
    UserRepository uRepo;

    @Test
    void test() {
        User u = uRepo.findByMailAndPassword("user1@mail.com","password1").get();
        System.out.println("Ciao");

    }

}
