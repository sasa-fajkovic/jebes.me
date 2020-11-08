package me.jebes.generator.service

import me.jebes.generator.model.Sentence
import me.jebes.generator.repository.SentenceRepository
import org.springframework.stereotype.Service

@Service
class SentenceService(
        private val repository: SentenceRepository
) {
    fun getRandomSentences(amount: UInt): List<Sentence> = repository.getRandomConfirmedSentences(amount)

    fun addNew(sentence: Sentence) = repository.save(sentence)
    fun updateIsAllowed(id: Long, value: Boolean) = repository.updateIsAllowed(id, value)
    fun getOne(id: Long) = repository.getOne(id)


}
