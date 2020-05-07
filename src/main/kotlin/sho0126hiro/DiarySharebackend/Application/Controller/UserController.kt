package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {

    @GetMapping("/test")
    fun test(): String{
        return "ok"
    }
}