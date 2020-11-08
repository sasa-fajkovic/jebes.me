package me.jebes.generator.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "SENTENCES")
data class Sentence(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val croatianValue: String,
        val englishValue: String,
        @JsonIgnore
        val isAllowed: Boolean
)
