package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;



@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    } 

    @Override
    public User findById(Long id) {
       return userRepository.findById(id).orElseThrow(NoSuchElementException:: new);
    }

    @Override
    public User create(User UsertoCreate) {
       if(UsertoCreate.getId() != null & userRepository.existsById(UsertoCreate.getId())){
        throw new IllegalArgumentException("This user ID already exists");
       }
    return null;
    }


}
