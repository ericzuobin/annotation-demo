package net.zuobin.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author Sahinn
 * @date 16/6/13
 */
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
