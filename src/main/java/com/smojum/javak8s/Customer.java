package com.smojum.javak8s;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
}
