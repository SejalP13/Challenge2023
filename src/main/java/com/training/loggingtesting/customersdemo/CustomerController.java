package com.training.loggingtesting.customersdemo;

import com.training.loggingtesting.customersdemo.exception.CustomerNotFoundException;
import com.training.loggingtesting.customersdemo.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/countrysales")
    public ResponseEntity<List<CountrySales>> getCountrySales(){

        return ResponseEntity.ok(service.getCountrySales());

    }

    @GetMapping
    public ResponseEntity<List<Customer>>  getAll(){
        return ResponseEntity.ok(service.getAllOrders());

    }

    @PostMapping("/users")
    public Customer saveUserDetails(@Valid @RequestBody Customer user) {
        return service.save(user);
    }
    /**
     * API for find all user details.
     * @return
     */
    @GetMapping("/users")
    public List<Customer> getUserDetails() {
        return service.findAll();
    }
    /**
     * API for find user details by firstname
     * @param firstname
     * @return
     */
    @GetMapping("/users/{firstname}")
    public Customer getUserDetailsByFirstName(@PathVariable(value = "firstname") String firstname) {
        return service.findByFirstname(firstname)
                .orElseThrow(() -> new CustomerNotFoundException("User", "firstname", firstname));
    }
    /**
     * API for update user address and age by firstname
     * @param firstname
     * @param userDetails
     * @return
     */
    @PutMapping("/users/{firstname}")
    public Customer updateUser(@PathVariable(value = "firstname") String firstname,
                           @Valid @RequestBody Customer userDetails) {

        Customer user = service.findByFirstname(firstname)
                .orElseThrow(() -> new CustomerNotFoundException("User", "firstname", firstname));

        user.setAddress(userDetails.getAddress());
        user.setAge(userDetails.getAge());

        Customer updatedUser = service.save(user);
        return updatedUser;
    }
    /**
     * API for delete user details by firstname
     * @param firstname
     * @return
     */
    @DeleteMapping("/users/{firstname}")
    public ResponseEntity<?> deleteIUser(@PathVariable(value = "firstname") String firstname) {
        Customer user = service.findByFirstname(firstname)
                .orElseThrow(() -> new CustomerNotFoundException("Items", "firstname", firstname));

        service.delete(user);

        return ResponseEntity.ok().build();
    }

}

//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @Autowired
//    UserRepository userRepo;
//    /**
//     * API for save user details.
//     * @param user
//     * @return
//     */
//    @PostMapping("/users")
//    public User saveUserDetails(@Valid @RequestBody User user) {
//        return userRepo.save(user);
//    }
//    /**
//     * API for find all user details.
//     * @return
//     */
//    @GetMapping("/users")
//    public List<User> getUserDetails() {
//        return userRepo.findAll();
//    }
//    /**
//     * API for find user details by firstname
//     * @param firstname
//     * @return
//     */
//    @GetMapping("/users/{firstname}")
//    public User getUserDetailsByFirstName(@PathVariable(value = "firstname") String firstname) {
//        return userRepo.findByFirstname(firstname)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "firstname", firstname));
//    }
//    /**
//     * API for update user address and age by firstname
//     * @param firstname
//     * @param userDetails
//     * @return
//     */
//    @PutMapping("/users/{firstname}")
//    public User updateUser(@PathVariable(value = "firstname") String firstname,
//                           @Valid @RequestBody User userDetails) {
//
//        User user = userRepo.findByFirstname(firstname)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "firstname", firstname));
//
//        user.setAddress(userDetails.getAddress());
//        user.setAge(userDetails.getAge());
//
//        User updatedUser = userRepo.save(user);
//        return updatedUser;
//    }
//    /**
//     * API for delete user details by firstname
//     * @param firstname
//     * @return
//     */
//    @DeleteMapping("/users/{firstname}")
//    public ResponseEntity<?> deleteIUser(@PathVariable(value = "firstname") String firstname) {
//        User user = userRepo.findByFirstname(firstname)
//                .orElseThrow(() -> new ResourceNotFoundException("Items", "firstname", firstname));
//
//        userRepo.delete(user);
//
//        return ResponseEntity.ok().build();
//    }
//}

