package com.github.sparsick.test.tool.database;

import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class DbMigrationJUnit4Test {
    
    @Rule
    public MySQLContainer mysqlDb = new MySQLContainer();
    
    @Test
    public void testDbMigrationFromTheScratch(){
        Flyway flyway = Flyway.configure().dataSource(mysqlDb.getJdbcUrl(), mysqlDb.getUsername(), mysqlDb.getPassword()).load();


        flyway.migrate();
    }
    
}