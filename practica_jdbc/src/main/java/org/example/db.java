package org.example;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class db {
    private static MysqlDataSource ds;

    public static DataSource getDataSource() {
        if (ds ==null) {
            MysqlDataSource m = new MysqlDataSource();
            m.setURL("jdbc:mysql://localhost:3306/demo");
            m.setUser("root");
            m.setPassword("123456789");
            ds = m;
            }
        return ds;
    }

        public void testconection(){
        try{
            DataSource ds = getDataSource();
            ds.getConnection();
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
}
    }
}
