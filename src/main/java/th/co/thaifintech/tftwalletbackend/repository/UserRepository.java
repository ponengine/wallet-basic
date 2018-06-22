package th.co.thaifintech.tftwalletbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import th.co.thaifintech.tftwalletbackend.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
    
}
