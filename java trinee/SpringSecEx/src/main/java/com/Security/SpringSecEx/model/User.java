package com.Security.SpringSecEx.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
@Data
public class User {
    @Id
    private int id;
    private String username;
    private String password;


}
