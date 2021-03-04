package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> listUser();

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(Long id);

    public User getUserById(Long id);

}