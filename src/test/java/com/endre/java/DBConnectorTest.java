package com.endre.java;

import com.j256.ormlite.logger.LocalLog;
import org.h2.tools.Server;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DBConnectorTest {

    static Server server;
    ApplicationImplementation application;

    @BeforeClass
    public static void setUp() throws SQLException {
        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");
        System.out.println("Staring H2 server");
        server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers").start();
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Stopping H2 server");
        server.stop();
    }

    @Before
    public void setup() throws Exception{
        application = new ApplicationImplementation("DatabaseProperties.properties");
        application.setConnectorInterface(new H2ConnectionSource());
    }


    @Test
    public void areAllTablesCreated() throws Exception {
        assertEquals(3, application.createDB());
    }


}