package it.hww;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@Slf4j
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

}