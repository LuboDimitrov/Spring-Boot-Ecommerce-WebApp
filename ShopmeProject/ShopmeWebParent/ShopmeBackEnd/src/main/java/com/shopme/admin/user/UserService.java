package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //to let Spring inject an instance at runtime (dependency injection)
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    //to show roles in the new users form
    public List<Role> listRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }
}
