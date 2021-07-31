package com.example.challengespringboot.Services;

import com.example.challengespringboot.Models.CartoonCharacter;
import com.example.challengespringboot.Repositories.CartoonCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonCharacterServiceImpl implements CartoonCharacterService{

    private final CartoonCharacterRepository cartoonCharacterRepository;

    @Autowired
    public CartoonCharacterServiceImpl(CartoonCharacterRepository cartoonCharacterRepository){
        this.cartoonCharacterRepository=cartoonCharacterRepository;
    }

    @Override
    public List<CartoonCharacter> listOfCartoonCharacters() {
        return cartoonCharacterRepository.findAll();
    }

    @Override
    public void saveCartoonCharacter(CartoonCharacter newCartoonCharacter) {
        cartoonCharacterRepository.save(newCartoonCharacter);
    }
}
