package services;

import domain.models.User;

public interface UserService {

    User findByName(String name);
}
