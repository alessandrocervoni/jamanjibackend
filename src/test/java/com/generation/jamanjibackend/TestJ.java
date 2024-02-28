package com.generation.jamanjibackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.RestaurantRepository;
import com.generation.jamanjibackend.repositories.UserRepository;

@SpringBootTest
class TestJ {

    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantRepository rRepo;

    @Test
    void test() {
        // Restaurant rClosed = rRepo.findById(3).get();
        // boolean res1 = rOpen.isOpen();
        // boolean res2 = rClosed.isOpen();
        // System.out.println(rOpen.isOpen()+ " "+ rClosed.isOpen());

        Restaurant r = rRepo.findById(1).get();
        double distance = r.distance();
    }


}
