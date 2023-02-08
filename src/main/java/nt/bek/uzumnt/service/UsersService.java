package nt.bek.uzumnt.service;

import lombok.RequiredArgsConstructor;
import nt.bek.uzumnt.dto.ResponseDTO;
import nt.bek.uzumnt.dto.UsersDTO;
import nt.bek.uzumnt.model.Users;
import nt.bek.uzumnt.repository.UserRepository;
import nt.bek.uzumnt.service.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .success(true)
                .data(UsersMapper.toDTO(entity))
                .build();
    }
    public ResponseDTO<List<UsersDTO>> getAll() {
        List<UsersDTO> users = repository.findAllByIsActive(1).stream().map(user -> UsersMapper.toDTO(user)).toList();
        return ResponseDTO.<List<UsersDTO>>builder()
                .code(0)
                .message("OK")
                .success(true)
                .data(users)
                .build();
    }
    public ResponseDTO<UsersDTO> getById(Integer id){
        return repository.findByIdAndAndIsActive(id,1)
                .map(a->ResponseDTO.<UsersDTO>builder()
                    .code(0)
                    .message("OK")
                    .success(true)
                    .data(UsersMapper.toDTO(a))
                    .build())
                .orElse(ResponseDTO.<UsersDTO>builder()
                        .code(-1)
                        .message("User with id "+id+"not found")
                        .build());
    }
    public ResponseDTO<UsersDTO> edit(UsersDTO user){
        if(user.getId()==null){
            return ResponseDTO.<UsersDTO>builder()
                    .code(-2)
                    .message("No ID")
                    .data(null)
                    .build();
        }
        Optional<Users> usersOptional=repository.findByIdAndAndIsActive(user.getId(),1);
        if(usersOptional.isEmpty()){
            return ResponseDTO.<UsersDTO>builder()
                    .code(-1)
                    .message("User with id "+user.getId()+"not exists")
                    .data(null)
                    .build();
        }
        if(user.getBirthDate()!=null){
            usersOptional.get().setBirthDate(user.getBirthDate());
        }
        if(user.getEmail()!=null){
            usersOptional.get().setEmail(user.getEmail());
        }
        if(user.getFirstName()!=null){
            usersOptional.get().setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            usersOptional.get().setLastName(user.getLastName());
        }
        if(user.getMiddleName()!=null){
            usersOptional.get().setMiddleName(user.getMiddleName());
        }
        if(user.getGender()!=null){
            usersOptional.get().setGender(user.getGender());
        }
        if(user.getPhoneNumber()!=null){
            usersOptional.get().setPhoneNumber(user.getPhoneNumber());
        }
        return ResponseDTO.<UsersDTO>builder()
                .code(0)
                .success(true)
                .message("OK")
                .data(UsersMapper.toDTO(usersOptional.get()))
                .build();
    }

    public ResponseDTO<UsersDTO> getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber)
                .map(a->ResponseDTO.<UsersDTO>builder()
                    .code(0)
                    .success(true)
                    .message("OK")
                    .data(UsersMapper.toDTO(a))
                    .build())
                .orElse(ResponseDTO.<UsersDTO>builder()
                        .code(-1)
                        .message("not found")
                        .build()
                );
    }

    public ResponseDTO<UsersDTO> deleteById(Integer id) {
        Optional<Users> user= repository.findByIdAndAndIsActive(id,1);
        if(user.isEmpty()){
            return ResponseDTO.<UsersDTO>builder()
                    .message("User with id"+id+" not found")
                    .code(-1)
                    .build();
        }
        user.get().setIsActive((short) 0);
        return ResponseDTO.<UsersDTO>builder()
                .success(true)
                .message("Deleted")
                .code(0)
                .data(UsersMapper.toDTO(repository.save(user.get())))
                .build();
    }
}
