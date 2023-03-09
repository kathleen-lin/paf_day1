package tfip.paf.ssfday1.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import tfip.paf.ssfday1.model.Customer;

@Repository
public class CustomerRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

private final String findAllSQL = "select * from customer where id = ?";
private final String findAllSQLLimit = "select * from customer limit ? offset ?";
//“select * from tv_shows limit ? offset ?”, limit, offset

public List<Customer> findAllCustomers(){

    final List<Customer> custList = new ArrayList<Customer>();

    final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQL, 5);

    while (rs.next()){
        Customer cust = new Customer();
        cust.setId(rs.getInt("id"));
        cust.setFirst_name(rs.getString("first_name"));
        cust.setLast_name(rs.getString("last_name"));
        cust.setDob(rs.getDate("dob"));
        custList.add(cust);

    }

    return Collections.unmodifiableList(custList);
}

public List<Customer> findAllCustomersWithLimit(int limit, int offset){

    final List<Customer> custList = new ArrayList<Customer>();

    final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQLLimit, limit, offset);

    while (rs.next()){
        Customer cust = new Customer();
        cust.setId(rs.getInt("id"));
        cust.setFirst_name(rs.getString("first_name"));
        cust.setLast_name(rs.getString("last_name"));
        cust.setDob(rs.getDate("dob"));
        custList.add(cust);

    }

    return Collections.unmodifiableList(custList);
}
}
