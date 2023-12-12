package com.Xworkz.PasspoerProjectMngt.service.impl;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;
import com.Xworkz.PasspoerProjectMngt.repository.UserRepository;
import com.Xworkz.PasspoerProjectMngt.repository.impl.UserRepositoryImpl;
import com.Xworkz.PasspoerProjectMngt.service.UserService;


import java.util.List;

public class UserServiceImpl implements UserService {

   UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    public boolean validateAndAddUserRegistration(UserDTO dto) {
        System.out.println("service validation layer ");
        if (dto != null) {
            userRepository.addUserRegistration(dto);
            return true;
        }

        return false;
    }


    public boolean getUserByNameAndPassword(String loginId, String password) {

        List<UserDTO> usersDTO = userRepository.getUserByNameAndPassword(loginId, password);
        if (!usersDTO.isEmpty()){
            return  true;
        }
        return false;
    }

    public List<UserDTO> getAllInfo() {

        return userRepository.getAllInfo();
    }

    public UserDTO getInfoById(int id) {
        return userRepository.getInfoById(id);
    }

    public UserDTO validateAndUpdateInfoById(int id, UserDTO dto) {
        return userRepository.updateInfoById(id,dto);
    }

    @Override
    public UserDTO validateAndDeleteUserById(int id) {
        return userRepository.deleteUserById(id);
    }



}
