package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
                                                //<T:entity, ID: entity id
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
