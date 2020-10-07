package me.jebes.generator.service

import me.jebes.generator.model.Sentence
import me.jebes.generator.repository.SentenceRepository
import org.springframework.stereotype.Service

@Service
class SentenceService(
        private val repository: SentenceRepository
) {
    fun getRandomSentences(amount: UInt): List<Sentence> {
        return repository.getRandomConfirmedSentences(amount)
    }
}
