package com.training.loggingtesting.customersdemo.services;

import com.training.loggingtesting.customersdemo.CountrySales;
import com.training.loggingtesting.customersdemo.Customer;
import com.training.loggingtesting.customersdemo.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;
    public List<Customer> getAllOrders(){
        return  repo.findAll(); }

    public Customer getOrderById(String id){
        return repo.findById(id).get();
    }

    public List<CountrySales> getCountrySales(){
        List<CountrySales> sales = new ArrayList<>();
        //AggregationResults<List<Order>> orders =  repo.getCountryWiseRevenue();

        List<Customer> orders =  repo.getCountryWiseRevenue();
       // orders.forEach((eList)->{
           orders.forEach(e->{
             CountrySales sale =  new CountrySales();
            sale.setCountry(e.getCountry());
            sale.setTotal_sales(e.getPrice()*e.getQuantity());

            sales.add(sale);
        });

        return sales;

    }
}
