package br.com.bank.model.domain;

import java.time.LocalDateTime;

public class StandardErrorModel {

    private String message, error, timeStamp;

    public static StandardErrorModel valueOf (Exception exception) {

        var stm = new StandardErrorModel();
        stm.error = exception.getCause().toString();
        stm.message = exception.getMessage();
        stm.timeStamp = LocalDateTime.now().toString();
        return stm;

    }

}
