package me.jebes.generator.repository

import me.jebes.generator.model.Sentence
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SentenceRepository : JpaRepository<Sentence, Long> {

    @Query(value = "SELECT * FROM SENTENCES WHERE IS_ALLOWED = true ORDER BY random() LIMIT :amount", nativeQuery = true)
    fun getRandomConfirmedSentences(amount: UInt): List<Sentence>
}
