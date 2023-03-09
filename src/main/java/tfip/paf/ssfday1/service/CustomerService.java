package tfip.paf.ssfday1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.paf.ssfday1.model.Customer;
import tfip.paf.ssfday1.repository.CustomerRepo;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepo custRepo;

    public List<Customer> retrieveAllCustomer(){
        return custRepo.findAllCustomers();
    }

    public List<Customer> retrieveAllCustomers(int limit, int offset){
        return custRepo.findAllCustomersWithLimit(limit, offset);
    }
}
