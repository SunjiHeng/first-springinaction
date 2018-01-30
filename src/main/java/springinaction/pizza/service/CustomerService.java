package springinaction.pizza.service;
import org.springframework.stereotype.Component;
import springinaction.pizza.domain.Customer;

@Component
public interface CustomerService {
   Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}