package me.jebes.generator.service

import me.jebes.generator.model.Sentence
import me.jebes.generator.repository.SentenceRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
class SentenceServiceTest {
    private val repository: SentenceRepository = Mockito.mock(SentenceRepository::class.java)

    private val service: SentenceService = SentenceService(repository)

    @BeforeAll
    fun setup() {
        Mockito.`when`(
                repository.getRandomConfirmedSentences(2u)
        ).thenReturn(listOf(
                Sentence(1, "C1", "E1", true),
                Sentence(2, "C2", "E2", true)))
    }

    @Test
    fun shouldReturnListWithSentences() {
        val sentences = service.getRandomSentences(2u)
        assertEquals(sentences.size, 2)
        assertTrue(sentences.contains(Sentence(1, "C1", "E1", true)))
        assertTrue(sentences.contains(Sentence(2, "C2", "E2", true)))
    }

    @Test
    fun shouldReturnEmptyList() {
        val sentences = service.getRandomSentences(0u)
        assertEquals(sentences.size, 0)
    }
}