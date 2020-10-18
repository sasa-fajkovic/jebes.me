package me.jebes.generator.repository

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
class SentenceRepositoryTest {

    @Autowired
    lateinit var sentenceRepository: SentenceRepository

    @Test
    fun shouldGetRandomSentences() {
        val counterMap = HashMap<Long, Int>()

        for (i in 0..10) {
            val sentences = sentenceRepository.getRandomConfirmedSentences(3u)

            for (s in sentences) {
                counterMap[s.id] = counterMap.getOrDefault(s.id, 0) + 1
            }
        }

        assertTrue((counterMap[0] != counterMap[1]) && (counterMap[0] != counterMap[2]))
    }
}