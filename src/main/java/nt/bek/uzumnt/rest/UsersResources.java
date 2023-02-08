package nt.bek.uzumnt.rest;

import lombok.RequiredArgsConstructor;
import nt.bek.uzumnt.dto.ResponseDTO;
import nt.bek.uzumnt.dto.UsersDTO;
import nt.bek.uzumnt.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersResources {
    private final UsersService service;

    @PostMapping
    public ResponseDTO<UsersDTO> addUser(@RequestBody UsersDTO user){
        return service.addUser(user);
    }
    @GetMapping
    public ResponseDTO<List<UsersDTO>> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseDTO<UsersDTO> getById(@PathVariable Integer id){
        return service.getById(id);
    }
    @GetMapping("by-phone-number")
    public ResponseDTO<UsersDTO> getByPhoneNumber(@RequestParam String phoneNumber){
        return service.getByPhoneNumber(phoneNumber);
    }
    @PatchMapping
    public ResponseDTO<UsersDTO> patch(@RequestBody UsersDTO userDto){
        return service.edit(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseDTO<UsersDTO> deleteUser(@PathVariable Integer id){
        return service.deleteById(id);
    }

}
