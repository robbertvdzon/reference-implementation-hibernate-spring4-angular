package com.vdzon.contactdb.authenticatie.rest;

import com.vdzon.contactdb.authenticatie.mapper.UserModelMapper;
import com.vdzon.contactdb.authenticatie.model.UserModel;
import com.vdzon.contactdb.authenticatie.repository.UserRepository;
import com.vdzon.contactdb.authenticatie.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestMapping("/authentication")
@RestController
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UserRepository userService;

    @Inject
    AuthenticationService authenticationService;

    @GET
    @RequestMapping("/getauthentication")
    public ResponseEntity<UserModel> getUser() {
        long userId = authenticationService.getUserId();
        if (userId == -1) {
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }
        UserModel userModel = UserModelMapper.toModel(userService.findOne(userId));
        return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
    }

}
