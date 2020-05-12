package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho0126hiro.DiaryShareBackend.application.resource.DiaryBody
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.service.DiaryService
import javax.validation.Valid

/**
 * 日記に関する処理
 */
@RestController
@RequestMapping("diary")
class DiaryController (
        val diaryService: DiaryService
){

    /**
     * 日記投稿処理
     * @param diary:
     *  Diary( userId, status, title, content )
    val createdAt: String? = null
     *
     */
    @PostMapping("/create")
    fun crate(@Valid @RequestBody diary: DiaryBody): ResponseBody{
        val diaryBody: DiaryBody = diaryService.create(diary.toDomainObject())
        return ResponseBody(
                "create success", diaryBody
        )
    }

    /**
     * 日記編集
     * Diary( id, userId, status, title, content, null...)
     */
    @PostMapping("/edit")
    fun edit(@Valid @RequestBody diary: DiaryBody): ResponseBody {
        val diaryBody: DiaryBody = diaryService.edit(diary.toDomainObject())
        return ResponseBody(
                "edit success", diaryBody
        )
    }

    /**
     * change status
     * Diary(id, status,  null...)
     */
    @PostMapping("/change_status")
    fun changeStatus(@Valid @RequestBody diary: DiaryBody): ResponseBody {
        val diaryBody: DiaryBody = diaryService.changeStatus(diary.toDomainObject())
        return ResponseBody(
                "change_status success", requireNotNull(diaryBody.status)
        )
    }
}