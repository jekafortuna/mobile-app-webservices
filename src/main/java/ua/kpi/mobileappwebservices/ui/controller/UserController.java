package ua.kpi.mobileappwebservices.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.mobileappwebservices.ui.model.request.UserDetailsRequestModel;
import ua.kpi.mobileappwebservices.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "40") int limit,
                           @RequestParam(value = "sort", defaultValue = "descending", required = false) String sort){
        return "getUser was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {
                                                MediaType.APPLICATION_XML_VALUE,
                                                MediaType.APPLICATION_JSON_VALUE
                                                })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        UserRest returnValue = new UserRest();

        returnValue.setEmail("user@gmail.com");
        returnValue.setFirstName("Joe");
        returnValue.setLastName("Dante");

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PostMapping(consumes = {
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                            },
                 produces = {
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                            })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }
}
