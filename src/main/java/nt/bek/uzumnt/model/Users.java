package nt.bek.uzumnt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;

@Entity
@Getter
@Setter
public class Users {
    @Id
    private Integer id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String birthDate;
    private String email;
    private String gender;
}
