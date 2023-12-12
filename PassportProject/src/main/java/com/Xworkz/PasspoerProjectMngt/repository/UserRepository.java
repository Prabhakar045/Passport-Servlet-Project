package com.Xworkz.PasspoerProjectMngt.repository;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    public  void addUserRegistration(UserDTO dto);

    public List<UserDTO> getUserByNameAndPassword(String loginId, String password);

    public  List<UserDTO>   getAllInfo();

    public UserDTO getInfoById(int id);


    public UserDTO updateInfoById(int id, UserDTO dto );


    public UserDTO deleteUserById(int id);

}
