package springinaction.pizza.flow;

import static springinaction.pizza.domain.PaymentType.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springinaction.pizza.domain.CashOrCheckPayment;
import springinaction.pizza.domain.CreditCardPayment;
import springinaction.pizza.domain.Customer;
import springinaction.pizza.domain.Order;
import springinaction.pizza.domain.Payment;
import springinaction.pizza.domain.PaymentDetails;
import springinaction.pizza.service.CustomerNotFoundException;
import springinaction.pizza.service.CustomerService;

@Component
public class PizzaFlowActions {
//  private static final Logger LOGGER = getLogger(PizzaFlowActions.class);
  
   public Customer lookupCustomer(String phoneNumber) 
         throws CustomerNotFoundException {     
      Customer customer = customerService.lookupCustomer(phoneNumber);
      if(customer != null) {        
        return customer;
      } else {
        throw new CustomerNotFoundException();
      }
   }
   
   public void addCustomer(Customer customer) {
//      LOGGER.warn("TODO: Flesh out the addCustomer() method.");
   }

   public Payment verifyPayment(PaymentDetails paymentDetails) {
     Payment payment = null;
     if(paymentDetails.getPaymentType() == CREDIT_CARD) {
       payment = new CreditCardPayment();
     } else {
       payment = new CashOrCheckPayment();
     }
     
     return payment;
   }
   
   public void saveOrder(Order order) {
//      LOGGER.warn("TODO: Flesh out the saveOrder() method.");
   }
   
   public boolean checkDeliveryArea(String zipCode) {
//     LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
     return "75075".equals(zipCode);
   }

   @Autowired
   CustomerService customerService;
}
