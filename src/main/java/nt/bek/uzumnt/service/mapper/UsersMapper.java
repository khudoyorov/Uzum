package nt.bek.uzumnt.service.mapper;

import nt.bek.uzumnt.dto.UsersDTO;
import nt.bek.uzumnt.model.Users;

public class UsersMapper {
    public static Users toEntity(UsersDTO dto){
        Users user=new Users();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMiddleName(dto.getMiddleName());
        user.setGender(dto.getGender());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
    public static UsersDTO toDTO(Users entity){
        UsersDTO dto=new UsersDTO();
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setGender(entity.getGender());
        dto.setBirthDate(entity.getBirthDate());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
