package orm;

import com.mysql.jdbc.Driver;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author HP
 * @create 2018-02-09-16:57
 */
public class JDBCTest {



    private static final String sql2= "INSERT INTO user (username, password) VALUES ('username11','password11')";

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring-application-context.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean ("jdbcTemplate");

        System.out.println (jdbcTemplate);

        jdbcTemplate.update (sql2);
    }

    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver ();
        String url = "jdbc:mysql://localhost:3306/test";

        Properties info = new Properties ();
        info.setProperty ("user", "root");
        info.setProperty ("password", "mysql123456");

        Connection connect = driver.connect (url, info);

        String sql = "insert into user(username,password) values (?,?)";

        PreparedStatement preparedStatement = connect.prepareStatement (sql);

        preparedStatement.setString (1,"username");
        preparedStatement.setString (2,"password");


        preparedStatement.execute ();


    }
}
