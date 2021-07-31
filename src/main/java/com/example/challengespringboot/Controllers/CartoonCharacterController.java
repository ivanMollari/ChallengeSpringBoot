package com.example.challengespringboot.Controllers;

import com.example.challengespringboot.Models.CartoonCharacter;
import com.example.challengespringboot.Services.CartoonCharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class CartoonCharacterController {

    private final CartoonCharacterServiceImpl cartoonCharacterService;

    @Autowired
    public CartoonCharacterController(CartoonCharacterServiceImpl cartoonCharacterService) {
        this.cartoonCharacterService = cartoonCharacterService;
    }

    @GetMapping("/characters")
    public String listOfCartoonCharacters(Model model) {
        List<CartoonCharacter> cartoonCharacterList = cartoonCharacterService.listOfCartoonCharacters();
        model.addAttribute("listOfCartoonCharacters", cartoonCharacterList);
        return "cartoonCharacter";
    }

    @GetMapping("/form/character")
    public String formAddCartoonCharacter(Model model) {
        model.addAttribute("cartoonCharacter", new CartoonCharacter());
        return "formAddCartoonCharacter";
    }

    @PostMapping("/add/character")
    public String addCharacter(@Validated @ModelAttribute CartoonCharacter cartoonCharacter,
                               BindingResult result,
                               Model model,
                               @RequestParam("file") MultipartFile image,
                               RedirectAttributes attribute) {

        if (result.hasErrors()) {
            attribute.addFlashAttribute("msg", "Existen errores");
            return "redirect:/characters";
        }

        if(!image.isEmpty()){
            Path directoryImages = Paths.get("src//main//resources//static/img");
            String absolutePath = directoryImages.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();
                Path fullPath = Paths.get(absolutePath + "//" + image.getOriginalFilename());
                Files.write(fullPath,bytesImg);
                cartoonCharacter.setUrlImg(image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        cartoonCharacterService.saveCartoonCharacter(cartoonCharacter);
        attribute.addFlashAttribute("msg", "animated character successfully saved");
        return "redirect:/characters";

    }

}
