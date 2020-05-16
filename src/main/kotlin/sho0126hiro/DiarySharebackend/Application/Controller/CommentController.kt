package sho0126hiro.DiaryShareBackend.application.controller

import org.apache.coyote.Response
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho0126hiro.DiaryShareBackend.application.resource.CommentBody
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Comment
import sho0126hiro.DiaryShareBackend.domain.service.CommentService
import javax.validation.Valid

@RestController
@RequestMapping("comment")
class CommentController (
        val commentService: CommentService
){
    /**
     * コメントの追加
     * commentBody(userId, diaryId, content, null...)
     */
    @PostMapping("/create")
    fun create(@Valid @RequestBody comment: CommentBody): ResponseBody{
        val commentBody: CommentBody = commentService.create(comment.toDomainObject())
        return ResponseBody(
                "comment create success",
                commentBody
        )
    }

    @PostMapping("/edit")
    fun edit(@Valid @RequestBody comment: CommentBody): ResponseBody{
        val commentBody: CommentBody = commentService.edit(comment.toDomainObject())
        return ResponseBody(
                "comment edit success",
                commentBody
        )
    }
}