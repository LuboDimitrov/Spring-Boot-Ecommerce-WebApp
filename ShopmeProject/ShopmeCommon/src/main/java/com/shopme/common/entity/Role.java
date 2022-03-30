package com.shopme.common.entity;


import javax.persistence.*;

@Entity
@Table(name = "roles") //table in the DB
public class Role {

    @Id
    //strategy is used to generate the values automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //unique = true -> two roles cant have the same name
    @Column(length = 40, nullable = false, unique = true)
    private String name;
    @Column(length = 150, nullable = false)
    private String description;

    //empty constructor required by hibernate
    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
