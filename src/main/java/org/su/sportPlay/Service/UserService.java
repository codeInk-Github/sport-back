package org.su.sportPlay.Service;

import org.apache.ibatis.annotations.Param;
import org.su.sportPlay.pojo.User;

import java.util.List;

public interface UserService {
    User getUserByNameAndPass(User user);
    List<User> getAllUser(String username,int pageStart,int pageSize);
    //public int getUserByMassage(String username, String password);
    public int getUserCounts( String username);
    public int updateState(Integer id, Boolean state);
    public int addUser(User user);
    public User getUser(int id);
    public int editUser(User user);
    public int deleteUser(int id);
}
