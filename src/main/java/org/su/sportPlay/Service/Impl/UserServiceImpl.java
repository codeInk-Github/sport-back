package org.su.sportPlay.Service.Impl;

import org.springframework.stereotype.Service;
import org.su.sportPlay.Service.UserService;
import org.su.sportPlay.mapper.UserMapper;
import org.su.sportPlay.pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPass(User user) {
        return userMapper.getUserByNameAndPass(user.getUsername(),
                user.getPassword());
    }

    @Override
    public List<User> getAllUser(String username, int pageStart, int pageSize) {
        System.out.println("username: "+username);
        System.out.println("pageStart:"+pageStart);
        System.out.println("pageSize:"+pageSize);
        return userMapper.getAllUser(username,pageStart,pageSize);
    }

    @Override
    public int getUserCounts(String username) {
        return userMapper.getUserCounts(username);
    }

    @Override
    public int updateState(Integer id, Boolean state) {
        return userMapper.updateState(id,state);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

}
