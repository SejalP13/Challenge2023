package com.training.loggingtesting.customersdemo.repos;

import com.training.loggingtesting.customersdemo.Customer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends MongoRepository<Customer,String> {

    Optional<Customer> findByFirstname(String firstName);


    @Aggregation(pipeline = {
            "{'$group':{_id:'$country',total:{$sum:'$sales'}}}"
    })
  //  AggregationResults <List<Order>> getCountryWiseRevenue();

List<Customer> getCountryWiseRevenue();


}
