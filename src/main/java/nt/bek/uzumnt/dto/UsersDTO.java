package nt.bek.uzumnt.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter@Setter
public class UsersDTO {
    private Integer id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private Date birthDate;
    private String email;
    private String gender;
    private String phoneNumber;
}
