package top.mapku.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Component
public class Scheduler {
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    private String host = "localhost";
    private String dbName = "ssyd";
    private String path = "~/backup";

    @Scheduled(fixedRate = 1 * Constant.SECONDS_ONE_DAY)
    public void backupSql() {
        String command = String.format("mysqldump --user=%s --password=%s --host=%s %s > %s/%s.sql", user, password, host, dbName, path, new Date().toString());
        System.out.println(command);
    }
}
