package edu.icet.ecom.service;

import edu.icet.ecom.dto.Customer;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer, Integer customerId);
    List<Customer> getAllCustomers();
    Customer searchCustomer(Integer customerId);
    boolean deleteCustomer(Integer customerId);
    public Integer calc(Integer a , Integer b);
    public String getNames(String name);
}
