package springinaction.mvc.basic;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @author HP
 * @create 2018-01-10-11:00
 */
public class Spittle {
    @Getter private final Long id;
    @Getter private final  String message;
    @Getter private final Date time;
    @Getter private Double latitude;
    @Getter private Double longitude;

    public Spittle(String message, Date time) {
        this (message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id=null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals (this, obj, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode (this, "id", "time");
    }
}
