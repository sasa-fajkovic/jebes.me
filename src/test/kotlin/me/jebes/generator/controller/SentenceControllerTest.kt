package me.jebes.generator.controller

import me.jebes.generator.service.SentenceService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SentenceControllerTest {
    @LocalServerPort
    private val port = 0

    val restTemplate: TestRestTemplate = TestRestTemplate()

    @Mock
    private lateinit var sentenceService: SentenceService

    @Test
    fun shouldVerifyEndpointForRetrievingSentencesExists() {
        val response = restTemplate.getForEntity("http://localhost:${port}/api/sentences?amount=5", String::class.java)

        assertTrue(response.statusCode.is2xxSuccessful)
    }
}