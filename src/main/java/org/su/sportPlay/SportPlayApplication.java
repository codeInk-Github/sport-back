package org.su.sportPlay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;


@SpringBootApplication
@MapperScan("org.su.sportPlay.mapper")
public class SportPlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlayApplication.class, args);

    }
}
