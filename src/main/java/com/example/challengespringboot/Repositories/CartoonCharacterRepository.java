package com.example.challengespringboot.Repositories;

import com.example.challengespringboot.Models.CartoonCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartoonCharacterRepository extends JpaRepository<CartoonCharacter,Long> {

}
