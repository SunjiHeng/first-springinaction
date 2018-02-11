package orm;

import com.mysql.jdbc.Driver;
import org.junit.Test;
import org.mockito.internal.configuration.FieldAnnotationProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import springinaction.mvc.basic.Spitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author HP
 * @create 2018-02-09-16:57
 */
public class JDBCTest {


    private static final String SQL_INSERT_1 = "INSERT INTO user (username, password) VALUES ('username11','password11')";
    private static final String SQL_SELECT = "select * from user where id = ( '? ')  ";
    private static final String SQL_INSERT_2 = "insert into user (username,password) values(:username,:password)";

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring-application-context.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean ("jdbcTemplate");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = context.getBean (NamedParameterJdbcTemplate.class);


//        jdbcTemplate.update (SQL_INSERT_1);

    }

    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver ();
        String url = "jdbc:mysql://localhost:3306/test";

        Properties info = new Properties ();
        info.setProperty ("user", "root");
        info.setProperty ("password", "mysql123456");

        Connection connect = driver.connect (url, info);

        String sql = "INSERT INTO user(username,password) VALUES (?,?)";

        PreparedStatement preparedStatement = connect.prepareStatement (sql);

        preparedStatement.setString (1, "username");
        preparedStatement.setString (2, "password");


        preparedStatement.execute ();


    }
}
