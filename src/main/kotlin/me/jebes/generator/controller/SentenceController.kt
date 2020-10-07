package me.jebes.generator.controller

import me.jebes.generator.model.Sentence
import me.jebes.generator.service.SentenceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/api/sentences")
class SentenceController(
        private val sentenceService: SentenceService
) {
    @GetMapping
    fun getRandomSentences(@PathParam("amount") amount: UInt): ResponseEntity<List<Sentence>> {
        return ResponseEntity(sentenceService.getRandomSentences(amount), HttpStatus.OK)
    }
}
