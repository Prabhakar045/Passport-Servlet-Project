package com.Xworkz.PasspoerProjectMngt.repository.impl;

import com.Xworkz.PasspoerProjectMngt.dto.UserDTO;
import com.Xworkz.PasspoerProjectMngt.entityManagerFactory.EntityManagerFactorySingleton;
import com.Xworkz.PasspoerProjectMngt.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public void addUserRegistration(UserDTO dto) {

        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(dto);
        transaction.commit();
    }


    public List<UserDTO> getUserByNameAndPassword(String loginId, String password) {
        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();


        Query query = entityManager.createNamedQuery("getUserByNameAndPassword", UserDTO.class);


        query.setParameter("un", loginId);
        query.setParameter("pwd", password);

        List<UserDTO> resultList = query.getResultList();

        entityManager.close();

        return resultList;
    }

    public List<UserDTO> getAllInfo() {
        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();
        Query query = entityManager.createNamedQuery("getAllInfo");

        List<UserDTO> resultList1 = query.getResultList();

        return resultList1;
    }

    public UserDTO getInfoById(int id) {
        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();


            Query query = entityManager.createNamedQuery("getInfoById");
            query.setParameter("id", id);

            List<UserDTO> resultList = query.getResultList();


           return resultList.get(0);

    }

    public UserDTO updateInfoById(int id, UserDTO updatedDto) {
        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


            transaction.begin();

            UserDTO user = entityManager.find(UserDTO.class, id);


                user.setGivenName(updatedDto.getGivenName());
                user.setSurname(updatedDto.getSurname());
                user.setEmail(updatedDto.getEmail());
                user.setLoginId(updatedDto.getLoginId());


                entityManager.merge(user);

                transaction.commit();
                return user;


    }


    public UserDTO deleteUserById(int id) {
        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        UserDTO user = entityManager.find(UserDTO.class, id);

        if (user != null) {
            entityManager.remove(user);
        }

        transaction.commit();
        return user;
    }



}
