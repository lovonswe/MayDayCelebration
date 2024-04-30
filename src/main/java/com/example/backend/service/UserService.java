package com.example.backend.service;

import com.example.backend.dto.CreateUserDto;
import com.example.backend.entity.Address;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addNewUser(CreateUserDto createUserDto){
        User user = mapCreateUserDtoToUser(createUserDto);
        return userRepository.save(user);
    }
    public Page<User> getUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }
    public User mapCreateUserDtoToUser(CreateUserDto createUserDto){
        Address address = new Address();
        address.setCountry(createUserDto.getCountry());
        address.setDistrict(createUserDto.getDistrict());
        User user = new User();
        user.setFullName(createUserDto.getFullName());
        user.setAddress(address);
        return user;
    }
}
