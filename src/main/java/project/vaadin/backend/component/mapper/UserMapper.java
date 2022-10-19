package project.vaadin.backend.component.mapper;

import org.springframework.stereotype.Component;
import project.vaadin.backend.model.dto.UserDto;
import project.vaadin.backend.model.entity.UserEntity;

@Component
public interface UserMapper {

      UserEntity userDtoToUserEntity (UserDto userDto);

     UserDto userEntityToUserDto(UserEntity userEntity);

}
