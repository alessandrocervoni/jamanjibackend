package com.generation.jamanjibackend.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWDistance;
import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWFull;
import com.generation.jamanjibackend.dto.restaurant.RestaurantDtoWPitagora;
import com.generation.jamanjibackend.entities.Restaurant;
import com.generation.jamanjibackend.entities.User;
import com.generation.jamanjibackend.repositories.RestaurantRepository;
import com.generation.jamanjibackend.repositories.UserRepository;

@Service
public class RestaurantConverter {

    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantRepository rRepo;
    
    public RestaurantDtoWFull RestoToDtoFull (Restaurant r){

        return  RestaurantDtoWFull
                .builder()
                .id(r.getId())
                .name(r.getName())
                .phone(r.getPhone())
                .openingHour(r.getOpeningHour())
                .closingHour(r.getClosingHour())
                .deliveryPricePerUnit(r.getDeliveryPricePerUnit())
                .maxDeliveryDistance(r.getMaxDeliveryDistance())
                .positionX(r.getPositionX())
                .positionY(r.getPositionY())
                .imgUrl(r.getImgUrl())
                .isOpen(r.isOpen())
                .foodTypes(r.getFoodTypes())
                .menu(r.getMenu())
                .build();
    }


    // metodo del delivery per la distanza

    public RestaurantDtoWPitagora RestToDtoPit (Restaurant r)
    {
        return  RestaurantDtoWPitagora
                .builder()
                .id(r.getId())
                .name(r.getName())
                .imgUrl(r.getImgUrl())
                .isOpen(r.isOpen())
                .foodTypes(r.getFoodTypes())
                .positionX(r.getPositionX())
                .positionY(r.getPositionY())
                .build();
    }
    public RestaurantDtoWDistance restToDtoWDistance (Restaurant r){
        
        return  RestaurantDtoWDistance
                .builder()
                .id(r.getId())
                .name(r.getName())
                .imgUrl(r.getImgUrl())
                .isOpen(r.isOpen())
                .foodTypes(r.getFoodTypes())
                .distance(0)
                .build();

    }
//     public int getDistance() {

//         double ipotenusa = 0;
    
//         User u = // ??????????? 
//         int x1 = u.getPositionX();
//         int y1 = u.getPositionY();

//         Restaurant r = getRestaurant();
//         int x2 = r.getPositionX();
//         int y2 = r.getPositionY();

//         double base = x1-x2;
//         double altezza = y1-y2;
//         ipotenusa = Math.sqrt(Math.pow(base,2)+Math.pow(altezza,2));
    

//         return (int)ipotenusa;
// }


}
