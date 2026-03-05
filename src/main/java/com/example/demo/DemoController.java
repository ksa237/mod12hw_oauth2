package com.example.demo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class DemoController {

    @Secured({"ROLE_READ"})
    @GetMapping("/role-read")
    public String readIsAllowed() {
        return "you have opened a section with -read- access";
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/role-write")
    public String writeIsAllowed() {
        return "you have opened a section with -write- access";
    }

    @PreAuthorize("hasRole('ROLE_DELETE') OR hasRole('ROLE_WRITE') ")
    @GetMapping("/at-least-one")
    public String atLeastOne() {
        return "you have opened the section where at least one (delete/write) of the roles is required";
    }

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/check-user")
    public String checkUser(@RequestParam("user") String username) {
        return "you have opened the section where the user -" + username + "- verification was performed";
    }

}
