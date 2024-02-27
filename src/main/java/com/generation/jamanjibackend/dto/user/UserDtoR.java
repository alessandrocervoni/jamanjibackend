package com.generation.jamanjibackend.dto.user;

import lombok.AllArgsConstructor;

import lombok.Data;


@Data
@AllArgsConstructor
   

    public class UserDtoR extends UserDtoBase
    {
        public UserDtoR(){}
        private Integer id;
    }
