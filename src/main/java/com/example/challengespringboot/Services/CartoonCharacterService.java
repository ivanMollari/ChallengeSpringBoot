package com.example.challengespringboot.Services;

import com.example.challengespringboot.Models.CartoonCharacter;

import java.util.List;

public interface CartoonCharacterService {

    List<CartoonCharacter> listOfCartoonCharacters();

    void saveCartoonCharacter(CartoonCharacter newCartoonCharacter);
}
