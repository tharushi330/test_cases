package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.repository.CustomerRepository;
import edu.icet.ecom.service.CustomerService;
import edu.icet.ecom.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean addCustomer(Customer customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer, Integer customerId) {
        CustomerEntity existingEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        modelMapper.map(customer, existingEntity);
        customerRepository.save(existingEntity);
        return true;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(customerEntity -> modelMapper.map(customerEntity, Customer.class))
                .toList();
    }

    @Override
    public Customer searchCustomer(Integer customerId) {
        CustomerEntity entity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        return modelMapper.map(entity, Customer.class);
    }

    @Override
    public boolean deleteCustomer(Integer customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;

    }

    @Override
    public Integer calc(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public String getNames(String name) {
        switch (name) {
            case "Nimal":
                return "A";

            case "Kamal":
                return "B";

            case "Sunil":
                return "C";
        }
        return name;

    }
}
