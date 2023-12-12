package com.Xworkz.PasspoerProjectMngt.service;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;

import java.util.List;

public interface UserService {

    public boolean validateAndAddUserRegistration(UserDTO dto);

    public boolean  getUserByNameAndPassword( String loginId , String password);

    public List<UserDTO> getAllInfo();

    public UserDTO getInfoById(int id);


    public UserDTO validateAndUpdateInfoById(int id, UserDTO dto );

    public UserDTO validateAndDeleteUserById(int id);



}
