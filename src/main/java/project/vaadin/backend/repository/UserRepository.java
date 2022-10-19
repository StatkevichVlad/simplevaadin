package project.vaadin.backend.repository;

import project.vaadin.backend.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer> {


    List<UserEntity> findByName(String name);

    List<UserEntity> findByPhone(Integer phone);

    List<UserEntity> findByAddress(String address);
}
