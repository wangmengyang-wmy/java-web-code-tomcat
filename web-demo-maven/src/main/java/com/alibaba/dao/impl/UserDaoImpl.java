package com.alibaba.dao.impl;

import com.alibaba.dao.UserDao;
import com.alibaba.entity.User;
import com.alibaba.utils.Constants;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean login(String name, String password) {
        boolean flag = false;
        Enumeration<String> keys = Constants.USER_MAP.keys();
        while (keys.hasMoreElements()){
            String s = keys.nextElement();
            User user = Constants.USER_MAP.get(s);
            String name1 = user.getName();
            String password1 = user.getPassword();
            if (password.equals(password1) && name1.equals(name)) {
                flag=true;
                break;
            }
        }
        return flag;
//        try {
//            try{
//                DBconnect.init();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            //注意查询语句中的单引号双引号
//            ResultSet rs = DBconnect.selectSql("select * from student where name='" + name + " 'and password='" + password + "';");
//            while (rs.next()) {
//                if (rs.getString("name").equals(name) && rs.getString("password").equals(password)) {
//                    flag = true;
//                }
//            }
//            DBconnect.closeConn();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 增
     */
    @Override
    public boolean register(User user) {
        return insert_and_update(user);
//        try{
//            DBconnect.init();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        int i = DBconnect.addUpdateDelete("insert into student(name,password,id) " +
//                "values('" + user.getName() + "','" + user.getPassword() + "','"+user.getId()+" ' )");
//        if (i > 0) {
//            flag = true;
//        }
//        DBconnect.closeConn();
//        return flag;
    }

    /**
     * 查
     */
    @Override
    public List<User> getUserAll() {
        List<User> list = new ArrayList<>();
        Enumeration<String> keys = Constants.USER_MAP.keys();
        while (keys.hasMoreElements()){
            String s = keys.nextElement();
            User user = Constants.USER_MAP.get(s);
            list.add(user);
        }
        return list;
//        try {
//            try{
//                DBconnect.init();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            ResultSet rs = DBconnect.selectSql("select * from student");
//            while (rs.next()) {
//                String nameone=rs.getString("name");
//                String passwordone=rs.getString("password");
//                String idone=rs.getString("id");
//                MyUser user=new MyUser(nameone,passwordone,idone);
//                list.add(user);
//            }
//            DBconnect.closeConn();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 删
     */
    @Override
    public boolean delete(String id) {
        boolean flag = false;
        User remove = Constants.USER_MAP.remove(id);
        if (remove != null && id.equals(remove.getId())) {
            flag = true;
        }
        return flag;
//        try{
//            DBconnect.init();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        String sql = "delete from student where id='" + id+"'";
//        int i = DBconnect.addUpdateDelete(sql);//i的意义：
//        if (i > 0) {
//            flag = true;
//        }
//        DBconnect.closeConn();

    }

    /**
     * 改
     */
    @Override
    public boolean update(User user) {
        return insert_and_update(user);

//        try{
//            DBconnect.init();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        String sql = "update student set name ='" + name
//
//                +"'"+"where id = '" + id+"'";
//
//        int i = DBconnect.addUpdateDelete(sql);
//        System.out.println("1"+" "+i);
//        if (i > 0) {
//            flag = true;
//        }
//        DBconnect.closeConn();
    }

    private boolean insert_and_update(User user) {
        boolean flag = false;
        String id = user.getId();
        // put返回的是一个null，如果要判断一个键值对有没有被put进去必须需要去遍历这个map集合
        Constants.USER_MAP.put(id,user);
        User user1 = Constants.USER_MAP.get(id);
        if (user1 !=null && user1.equals(user)) {
            System.out.println("equals:"+user1.equals(user));
            System.out.println(user.toString());
            System.out.println(user1.toString());
            flag=true;
        }
        return flag;
    }
}
