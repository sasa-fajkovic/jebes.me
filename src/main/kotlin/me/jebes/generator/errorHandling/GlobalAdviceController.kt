package me.jebes.generator.errorHandling

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class GlobalAdviceController {

    @ExceptionHandler (value = [EntityNotFoundException::class])
    fun handleEntityNotFoundException(): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}