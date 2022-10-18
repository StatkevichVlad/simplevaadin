package project.vaadin.backend.service;

import project.vaadin.backend.entity.UserEntity;
import project.vaadin.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> findAll(){
        return repository.findAll();
    }

    public List<UserEntity> findAll(String filterText){
        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.searchByName(filterText);
        }
    }

    public List<UserEntity> findAllByPhone(String filterText){
        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.searchByPhone(Integer.parseInt(filterText));
        }
    }

    public List<UserEntity> findAllByAddress(String filterText){
        if (filterText == null || filterText.isEmpty()){
            return repository.findAll();
        }
        else  {
            return repository.searchByAddress(filterText);
        }
    }

    public void addUser(String textFieldName, Integer textFieldPhone , String textFieldAddress){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(textFieldName);
        userEntity.setPhone(textFieldPhone);
        userEntity.setAddress(textFieldAddress);

        repository.save(userEntity);
    }
}
