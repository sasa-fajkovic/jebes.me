package me.jebes.generator.controller

import me.jebes.generator.dto.SentenceDto
import me.jebes.generator.model.Sentence
import me.jebes.generator.service.SentenceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@CrossOrigin
@RestController
@RequestMapping("/api/sentences")
class SentenceController(
        private val sentenceService: SentenceService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getRandomSentences(@PathParam("amount") amount: UInt): ResponseEntity<List<Sentence>> {
        return ResponseEntity(sentenceService.getRandomSentences(amount), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getSpecificSentence(@PathVariable("id") id: Long): ResponseEntity<Sentence> {
        return ResponseEntity(sentenceService.getOne(id), HttpStatus.OK)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun addNewSentence(@RequestBody sentenceDto: SentenceDto): ResponseEntity<String> {
        sentenceService.addNew(Sentence(
                id = null,
                croatianValue = sentenceDto.croatianValue,
                englishValue = sentenceDto.englishValue,
                isAllowed = false
        ))
        return ResponseEntity("Thank your for your entry.", HttpStatus.ACCEPTED)
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun allowOrDisallowSentence(@PathParam("isAllowed") value: Boolean, @PathVariable id: Long) {
        sentenceService.updateIsAllowed(id, value)
    }
}
