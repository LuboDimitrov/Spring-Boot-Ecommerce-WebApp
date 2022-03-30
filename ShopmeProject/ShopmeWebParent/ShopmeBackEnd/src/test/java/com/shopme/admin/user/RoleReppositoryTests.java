package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//to run the test against the real database (and not against a in-memory db)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//to commit the changes after running a test (quan executam el test que se guardin els resultats)
@Rollback(false)
public class RoleReppositoryTests {

    //dependecy injection (injects an instance of the role repository interface)
    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin", "manages everything");
        Role savedRole = repo.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles(){
        Role roleSalesPerson = new Role("SalesPerson", "manages products prices, customers, shipping, orders and sales reports");
        Role roleEditor = new Role("Editor", "manages categories, brands, products, articles and menus");
        Role roleShipper = new Role("Shipper", "view products, view orders, update order status");
        Role roleAssistant = new Role("Assistant", "manages questions and reviews");

        //save 'em all at once
        repo.saveAll(List.of(roleSalesPerson, roleEditor, roleShipper, roleAssistant));

    }
}
