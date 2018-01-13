package com.abid.sqlliteandroom.roomdb;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * Created by abid on 9/1/18.
 */

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDataBase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }
    public static void getEmpList(@NonNull final AppDataBase db) {
        GetAllEmpAsync task = new GetAllEmpAsync(db);
        task.execute();
    }
    private static UserInfo addUser(final AppDataBase db, UserInfo user) {
        db.userDao().insertUser(user);
        return user;
    }

    private static void populateWithTestData(AppDataBase db) {
        UserInfo user = new UserInfo();
        user.setEmp_first_name("Ajay");
        user.setEmp_last_name("Saini");
        user.setAge(25);
        user.setDesignamtion("Choota bheem");
        addUser(db, user);

        List<UserInfo> userList = db.userDao().getAllUser();
        Log.e(DatabaseInitializer.TAG, "Rows Count: " + userList.size()+" and the data is "+userList);
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final AppDataBase mDb;
        PopulateDbAsync(AppDataBase db) {
            mDb = db;
        }
        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }

    private static class GetAllEmpAsync extends AsyncTask<Void,Void,Void>{
        private final AppDataBase mDb2;
        GetAllEmpAsync(AppDataBase db) {
            mDb2 = db;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            getAllEmp(mDb2);
            return null;
        }
    }

    private static void getAllEmp(AppDataBase db){
        List<UserInfo> userList = db.userDao().getAllUser();
        Log.e(DatabaseInitializer.TAG, "Rows Count: " + userList.size()+" and the data is "+userList.toString());
        for (UserInfo userInfo:userList) {
            Log.e("user name is - ",userInfo.getEmp_first_name()+" "+userInfo.getEmp_last_name());
            Log.e("user age is - ",userInfo.getAge()+"");
            Log.e("user designation is - ",userInfo.getDesignamtion());
        }
    }
}
