package springinaction.mvc.data;

import org.springframework.stereotype.Component;
import springinaction.mvc.basic.Spittle;

import java.util.List;

/**
 * @author HP
 * @create 2018-01-10-10:58
 */
@Component
public interface SpitterRepository {
    List<Spittle> findSpittle(long max, int count);

    Spittle findOne(long spittleId);


    void save(Spittle spittle);

    List<Spittle> findRecentSpittles();
}
