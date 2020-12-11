package com.anis.mongodbboot.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Users {

    @Id
    private String id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String teamName;
    @Positive
    private Integer salary;
    private List<Reviews> reviews;
    private Address address;

    public Users(String name, String teamName, Integer salary, List<Reviews> reviews, Address address) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
        this.reviews = reviews;
        this.address = address;
    }
}
