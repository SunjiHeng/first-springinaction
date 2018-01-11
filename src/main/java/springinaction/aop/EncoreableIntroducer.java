package springinaction.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "springinaction.aop.Performance+", defaultImpl = springinaction.aop.DefaultEncoreable.class)
    public static Encoreable encoreable;
}
