package nt.bek.uzumnt.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter@Setter
public class UsersDTO {
    private Integer id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String  birthDate;
    private String email;
    private String gender;
    private String phoneNumber;
}
