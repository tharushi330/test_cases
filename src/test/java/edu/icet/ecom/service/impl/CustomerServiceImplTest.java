package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private CustomerServiceImpl service;

    private CustomerEntity customer1;
    private CustomerEntity customer2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        customer1 = CustomerEntity.builder()
                .customerId(1)
                .name("tharushi")
                .email("tharu@gmail.com")
                .build();

        customer2 = CustomerEntity.builder()
                .customerId(2)
                .name("bashi")
                .email("bashi@gmail.com")
                .build();
    }

    @Test
    public void getAllCustomerTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> customers = service.getAllCustomers();

        Assertions.assertNotNull(customers, "Products list should not be null");
        Assertions.assertEquals(2, customers.size(), "There should be exactly 2 products");
    }

    @Test
    public void addPCustomerTest() {




    }
}