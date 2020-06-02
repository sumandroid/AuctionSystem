package repositories;

import domain.models.User;
import exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User findByName(String name){
        Optional<User> userOptional = users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst();
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new EntityNotFoundException("no user with name: " + name);
    }

    public void save(User user){
        users.add(user);
    }
}
