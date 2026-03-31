package io.github.giannihonda.libraryapi.congig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.DriverManager;

@Configuration
public class DatabaseConfiguration {

    @Value(("${spring.datasource.url}"))
    String url;
    @Value(("${spring.datasource.username}"))
    String username;
    @Value(("${spring.datasource.password}"))
    String password;
    @Value(("${spring.datasource.driver-class-name}"))
    String driver;

    //@Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds;
    }

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(10); //max connections
        config.setMinimumIdle(1); //initial large pool
        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); //10min
        config.setConnectionTimeout(100000); //for obtain a connection
        config.setConnectionTestQuery("select 1"); //query for test

        return new HikariDataSource(config);
    }
}
