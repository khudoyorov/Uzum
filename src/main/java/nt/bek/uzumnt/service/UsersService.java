package nt.bek.uzumnt.service;

import lombok.RequiredArgsConstructor;
import nt.bek.uzumnt.dto.ResponseDTO;
import nt.bek.uzumnt.dto.UsersDTO;
import nt.bek.uzumnt.model.Users;
import nt.bek.uzumnt.repository.UserRepository;
import nt.bek.uzumnt.service.mapper.UsersMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository repository;
    public ResponseDTO<UsersDTO> addUser(UsersDTO user){
        Users entity=UsersMapper.toEntity(user);
        repository.save(entity);
        return ResponseDTO.<UsersDTO>builder()
                .code(0)
                .message("OK")
                .succes(true)
                .data(UsersMapper.toDTO(entity))
                .build();
    }
}
