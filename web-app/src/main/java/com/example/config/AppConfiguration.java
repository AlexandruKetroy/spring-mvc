package com.example.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class AppConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("testdb")
                .addScript("db/schema.sql")
                .addScript("db/data.sql")
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * Create and configure an H2 TCP Database server to access the database at the same time
     * from different processes or computers. Additionally, web console is started that can be accessed on <a href="http://localhost:8082">...</a>
     *
     * @return An instance of the H2 Server.
     * @throws SQLException If there's an issue during H2 server creation.
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemH2Server() throws SQLException {
        Server server =  Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");

        org.h2.tools.Console.main("-web", "-webAllowOthers");
        return server;
    }
}
