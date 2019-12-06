package com.example.datasource.service;

import com.example.datasource.annotation.DataSource;
import com.example.datasource.entity.UserEntity;
import com.example.datasource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @DataSource
    public void save(){
        UserEntity user = new UserEntity();
        user.setId("23423");
        user.setUsername("master1");
        user.setPassword("master1");
        user.setSex(1);
        user.setAge(18);
        userRepository.save(user);
    }

    @DataSource("slave1")
    public void getById(){
        UserEntity userEntity = new UserEntity();
        List<UserEntity> userEntityList = userRepository.findAll();
        if(userEntityList != null){
            userEntity = userEntityList.get(0);
        }
        System.out.println("年龄:"+userEntity.getAge());
        System.out.println("名字:"+userEntity.getUsername());
    }

    @DataSource("slave2")
    public void getById2(){
        UserEntity userEntity = new UserEntity();
        List<UserEntity> userEntityList = userRepository.findAll();
        if(userEntityList != null){
            userEntity = userEntityList.get(0);
        }
        System.out.println("年龄:"+userEntity.getAge());
        System.out.println("名字:"+userEntity.getUsername());
    }
}
