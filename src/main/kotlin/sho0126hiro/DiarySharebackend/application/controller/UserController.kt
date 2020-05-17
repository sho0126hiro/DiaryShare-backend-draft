package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.web.bind.annotation.*
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.application.resource.UserSearchResult
import sho0126hiro.DiaryShareBackend.domain.service.UserService
import javax.validation.Valid

@RestController
@RequestMapping("user")
class UserController (
        val userService: UserService
){

    /**
     * test
     */
    @GetMapping("/test")
    fun test(): String{
        return "ok"
    }

    /**
     * edit name
     * user: User(id, name, null...)
     */
    @PostMapping("/name/update")
    fun updateName(@Valid @RequestBody user: UserBody): ResponseBody {
        val userBody: UserBody = userService.updateName(user.toDomainObject())
        return ResponseBody("name update success", userBody)
    }

    /**
     * edit bio
     * user: User(id, bio, null...)
     */
    @PostMapping("/bio/update")
    fun updateBio(@Valid @RequestBody user: UserBody): ResponseBody {
        val userBody: UserBody = userService.updateBio(user.toDomainObject())
        return ResponseBody("bio update success", userBody)
    }

    /**
     * search user
     */
    @GetMapping("/search/{username}")
    fun findByUsername(@PathVariable username: String): ResponseBody{
        val result: UserSearchResult = userService.findByUsername(username)
        return ResponseBody(
                "target user: ${result.username} exist",
                result
        )
    }

}