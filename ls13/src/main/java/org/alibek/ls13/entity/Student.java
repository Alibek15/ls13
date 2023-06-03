package org.alibek.ls13.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;


@Data
//@Setter(value = AccessLevel.NONE)
@Table(name = "student")
@Entity
public class Student {
    @Id
    @Column(name="id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация айди по возрастанию
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
