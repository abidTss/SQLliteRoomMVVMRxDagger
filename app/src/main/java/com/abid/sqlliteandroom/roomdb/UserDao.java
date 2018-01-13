package com.abid.sqlliteandroom.roomdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by abid on 5/1/18.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM userInfo")
    List<UserInfo> getAllUser();

    @Query("SELECT * FROM userInfo where emp_first_name LIKE :firstName AND emp_last_name LIKE :lastName")
    UserInfo getUserByName(String firstName,String lastName);

    @Query("SELECT COUNT(*) from userInfo")
    int getUserCount();

    @Insert(onConflict = REPLACE)
    void insertUser(UserInfo... userInfos);

    @Delete
    void delete(UserInfo userInfo);


}
