package com.dariuszrychlik.petshop.api.model;

import lombok.Data;

@Data
public class PetDTO {
    Long id;
    String name;
    String status;
}
