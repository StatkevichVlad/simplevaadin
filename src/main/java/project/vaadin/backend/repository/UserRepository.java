package project.vaadin.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.vaadin.backend.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer> {

    @Query("select u from UserEntity u WHERE lower(u.name) like lower(concat('%' , :searchTerm ,'%'))")
    List<UserEntity> searchByName(@Param("searchTerm") String searchTerm);

    @Query("select u from  UserEntity  u WHERE u.phone = :searchParam")
    List<UserEntity> searchByPhone(@Param("searchParam") Integer searchParam);

    @Query("select u from UserEntity u WHERE lower(u.address) like lower(concat('%' , :searchTerm ,'%'))")
    List<UserEntity> searchByAddress(@Param("searchTerm") String searchTerm);
}
