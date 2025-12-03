package org.example.data;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    private static DataSource ds;
    public DataSourceProvider() {}

    public static DataSource get() {
        if (ds == null) {
            MysqlDataSource mds = new MysqlDataSource();
            mds.setUrl("jdbc:mysql://localhost:3306/liberia_db");
            mds.setUser("root");
            mds.setPassword("123456789");

            ds = mds;
        }
        return ds;
    }

}
