package br.com.bank.config.handler;

import br.com.bank.exception.ModelNotFoundException;
import br.com.bank.exception.UserExistsException;
import br.com.bank.model.domain.StandardErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<StandardErrorModel> modelNotFound(ModelNotFoundException ex){
        return ResponseEntity.status(404).body(StandardErrorModel.valueOf(ex));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<StandardErrorModel> userExists(ModelNotFoundException ex){
        return ResponseEntity.status(404).body(StandardErrorModel.valueOf(ex));
    }


}
