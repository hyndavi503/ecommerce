package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.User;

public interface UserDao 
{
public boolean addUser(User user);
public boolean updateUser(User user);
public boolean deleteUser(User user);
public User login(String email,String password);
public User getUser(long user_id);
public User getUserByEmail(String email);
public List<User>  getAllUserDetails();
}
