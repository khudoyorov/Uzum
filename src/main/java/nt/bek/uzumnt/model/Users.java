package nt.bek.uzumnt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "usersIdSeq")
    @SequenceGenerator(name = "usersIdSeq",sequenceName = "users_id_seq",allocationSize = 1)
    private Integer id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String gender;
    private Short isActive=1;
}