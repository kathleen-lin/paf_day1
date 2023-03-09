package tfip.paf.ssfday1.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfip.paf.ssfday1.model.Customer;
import tfip.paf.ssfday1.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    CustomerService custSvc;

    @GetMapping()
    public List<Customer> getCustomers(){
        
        return custSvc.retrieveAllCustomer();
    }

    @GetMapping("/offset")
    public List<Customer> getCustomers(@RequestParam int limit, @RequestParam int offset){
        
        return custSvc.retrieveAllCustomers(limit, offset);
    }

}
