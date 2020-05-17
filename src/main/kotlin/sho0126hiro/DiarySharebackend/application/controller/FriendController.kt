package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.web.bind.annotation.*
import sho0126hiro.DiaryShareBackend.application.resource.FriendBody
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.domain.service.FriendService
import javax.validation.Valid

@RestController
@RequestMapping("friend")
class FriendController (
        val friendService: FriendService
){
    /**
     * フレンド登録・申請など
     * FriendBody(userId, friendId)
     *
     */
    @PostMapping("/create")
    fun create(@Valid @RequestBody friend: FriendBody): ResponseBody{
        val friendBody: FriendBody = friendService.create(friend.toDomainObject())
        return ResponseBody(
                "success friend create",
                friendBody
        )
    }

    /**
     * フレンドの状態更新
     * 申請許可
     * FriendBody(userId, friendId, status)
     */
    @PostMapping("/change_status")
    fun changeStatus(@Valid @RequestBody friend: FriendBody): ResponseBody{
        val friendBody = friendService.changeStatus(friend.toDomainObject())
        return ResponseBody(
                "success change status",
                friendBody
        )
    }

    /**
     * フレンド削除
     */
    @DeleteMapping("/delete")
    fun delete(@Valid @RequestBody friendBody: FriendBody): ResponseBody{
        friendService.delete(friendBody.toDomainObject())
        return ResponseBody("delete success", {})
    }
}