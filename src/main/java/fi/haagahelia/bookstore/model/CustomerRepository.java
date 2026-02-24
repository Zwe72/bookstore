package fi.haagahelia.bookstore.model;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.bookstore.model.Customer;
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    
}