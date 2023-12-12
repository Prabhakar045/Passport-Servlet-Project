package com.Xworkz.PasspoerProjectMngt.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "passport_registration")
@NamedQueries({
        @NamedQuery(name = "getUserByNameAndPassword", query = "SELECT dto FROM UserDTO dto WHERE dto.loginId = :un AND dto.password = :pwd"),
        @NamedQuery(name = "getAllInfo" , query = "from UserDTO dto "),
        @NamedQuery(name = "getInfoById", query = "select dto FROM UserDTO dto WHERE dto.id = :id")
})
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String passportOffice;
    private String givenName;
    private String surname;
    private String dob;
    private String email;
    private String loginId;
    private String password;
    private String hintQuestion;
    private String hintAnswer;
}
