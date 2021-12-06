package com.xyc.wms.mapper;

import com.xyc.wms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User getUserInfo(int id);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public int save(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public int deleteById(int id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> selectAll();


    public User selectLoginUser(String userName,String passWord);

    public User selectLoginUser(String userName);



}
