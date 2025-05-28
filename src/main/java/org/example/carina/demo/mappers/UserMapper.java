package org.example.carina.demo.mappers;

import org.example.carina.demo.models.User;

public interface UserMapper {
    User findByUserName(String username);
}
