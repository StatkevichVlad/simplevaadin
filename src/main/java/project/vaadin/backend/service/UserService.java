package project.vaadin.backend.service;

import org.springframework.stereotype.Service;
import project.vaadin.backend.model.entity.UserEntity;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll();

    List<UserEntity> findByName(String filterText);

    List<UserEntity> findAllByPhone(String filterText);

    List<UserEntity> findAllByAddress(String filterText);

    void addUser(UserEntity userEntity);





}
