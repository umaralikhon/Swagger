package com.example.demo;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/find/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserResponse saveUser(@RequestBody UserRequest request){
        try{
            return userService.saveUser(request);
        }catch (Exception ex){
            return null;
        }
    }

    @PutMapping("/update")
    public UserResponse updateUser(@RequestBody UserRequest userRequest){
        try{
            return userService.updateUser(userRequest);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
