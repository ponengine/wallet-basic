package th.co.thaifintech.tftwalletbackend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.co.thaifintech.tftwalletbackend.entity.User;
import th.co.thaifintech.tftwalletbackend.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/adduser")
    public String addUser(@RequestBody User user){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	user.setCreateDate(sdf.format(new Date()));
    	userRepository.save(user);
    	return "Success";
    }
}
