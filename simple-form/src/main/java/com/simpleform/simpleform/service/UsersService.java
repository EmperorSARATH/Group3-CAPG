package com.simpleform.simpleform.service;

import com.simpleform.simpleform.model.UserModel;
import com.simpleform.simpleform.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserModel registerUser(String login,String password,String email){
        if(login!=null&&password!=null){
            if(usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate user");
                return null;
            }
            UserModel userModel =new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return usersRepository.save(userModel);
        }
        else return null;
    }
    public UserModel authenticate(String login,String password){
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
