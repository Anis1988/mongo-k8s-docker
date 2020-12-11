package com.anis.mongodbboot.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String country;
}
