package nt.bek.uzumnt.rest;

import lombok.RequiredArgsConstructor;
import nt.bek.uzumnt.dto.ResponseDTO;
import nt.bek.uzumnt.dto.UsersDTO;
import nt.bek.uzumnt.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersResources {
    private final UsersService service;

    @PostMapping
    public ResponseDTO<UsersDTO> addUser(@RequestBody UsersDTO user){
        return service.addUser(user);
    }
}
