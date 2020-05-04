package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.service.UserService

@RestController
@RequestMapping(path = ["/users"])
class UserController (val userService: UserService){
    @GetMapping("/search/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findbyId(@PathVariable("id") id: String): User {
        return userService.findById(id)
    }
}