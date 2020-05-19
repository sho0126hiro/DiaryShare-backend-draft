package sho0126hiro.DiaryShareBackend.application.controller

import org.apache.coyote.Response
import org.springframework.web.bind.annotation.*
import sho0126hiro.DiaryShareBackend.application.resource.LikeBody
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.domain.service.LikeService
import javax.validation.Valid

@RestController
@RequestMapping("like")
class LikeController (
        val likeService: LikeService
){
    /**
     * いいねをつける
     */
    @PostMapping("/create")
    fun create(@Valid @RequestBody like: LikeBody): ResponseBody {
        val l: LikeBody = likeService.create(like.toDomainObject())
        return ResponseBody(
                "like create success",
                l
        )
    }

    /**
     * いいねを取り消す
     */
    @DeleteMapping("/delete")
    fun delete(@Valid @RequestBody like: LikeBody): ResponseBody {
        likeService.delete(like.toDomainObject())
        return ResponseBody("delete success", {})
    }

}