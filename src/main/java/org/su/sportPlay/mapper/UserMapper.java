package org.su.sportPlay.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.su.sportPlay.pojo.User;

import java.util.List;

@Repository
public interface UserMapper {
    User getUserByNameAndPass(@Param("username") String username, @Param("password") String password);
    List<User> getAllUser(@Param("key") String key, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    int getUserCounts(@Param("username") String username);
    int updateState(Integer id, Boolean state);
    int addUser(User user);
    User getUser(int id);
    int editUser(User user);
    int deleteUser(int id);
}
