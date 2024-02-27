package com.generation.jamanji.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class UserDtoBase 
{     
    private String mail;
    private String password;
    private int positionX;
    private int positionY;
}