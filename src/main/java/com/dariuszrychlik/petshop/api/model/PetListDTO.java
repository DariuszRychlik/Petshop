package com.dariuszrychlik.petshop.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PetListDTO {

    private List<PetDTO> petList;
}
