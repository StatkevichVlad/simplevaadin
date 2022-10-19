package project.vaadin.backend.service.impl;

import project.vaadin.backend.model.entity.UserEntity;
import project.vaadin.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vaadin.backend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> findAll(){
        return repository.findAll();
    }


    public List<UserEntity> findByName(String filterText){

        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.findByName(filterText);
        }
    }

    public List<UserEntity> findAllByPhone(String filterText){
        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.findByPhone(Integer.parseInt(filterText));
        }
    }

    public List<UserEntity> findAllByAddress(String filterText){
        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.findByAddress(filterText);
        }
    }

    public void addUser(UserEntity userEntity){
        repository.save(userEntity);
    }
}
