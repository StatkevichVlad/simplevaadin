package project.vaadin.backend.component.mapper.impl;

import project.vaadin.backend.component.mapper.UserMapper;
import project.vaadin.backend.model.dto.UserDto;
import project.vaadin.backend.model.entity.UserEntity;

public class UserMapperImpl implements UserMapper {


    @Override
    public  UserEntity userDtoToUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDto.getName());
        userEntity.setPhone(userDto.getPhone());
        userEntity.setAddress(userDto.getAddress());

        return userEntity;
    }

    @Override
    public  UserDto userEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();

        userDto.setName(userEntity.getName());
        userDto.setPhone(userEntity.getPhone());
        userDto.setAddress(userEntity.getAddress());

        return userDto;
    }
}
