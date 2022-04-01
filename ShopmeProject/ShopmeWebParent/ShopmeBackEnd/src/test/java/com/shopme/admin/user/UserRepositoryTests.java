package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    //provided by Spring data JPA for unit testing
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        User  userLubo = new User("lubo@gmail.com", "12345678", "lubo", "dimitrov");
        //get the role we want to assign to the user
        Role roleAdmin = entityManager.find(Role.class, 1); //in our DB the admin role has id 1
        userLubo.addRole(roleAdmin);

        User savedUser = repo.save(userLubo);

        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testCreateUserWithTwoRoles() {
        User userTony = new User("tony@gmail.com", "tony12345", "Tony", "Smith");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        userTony.addRole(roleEditor);
        userTony.addRole(roleAssistant);

        User savedUser = repo.save(userTony);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> users = repo.findAll();
        users.forEach(System.out::println);

    }

    @Test
    public void testGetUsersById() {
        User userLubo = repo.findById(1).get();
        System.out.println(userLubo);
        assertThat(userLubo).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User userLubo = repo.findById(1).get();
        userLubo.setEnabled(true);
        userLubo.setEmail("lubo99@gmail.com");

        repo.save(userLubo);
    }

    @Test
    public void testUpdateUserRoles() {
        User userTony = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesPerson = new Role(2);

        userTony.getRoles().remove(roleEditor);
        userTony.addRole(roleSalesPerson);

        repo.save(userTony);
    }

    @Test
    public void testDeleteUser() {
       /* User toBeDeleted = repo.findById(7).get();
        repo.delete(toBeDeleted);*/
        repo.deleteById(2);
    }
}
