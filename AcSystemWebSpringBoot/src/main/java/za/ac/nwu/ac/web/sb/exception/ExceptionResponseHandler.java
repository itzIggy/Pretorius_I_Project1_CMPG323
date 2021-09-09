package za.ac.nwu.ac.web.sb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.ac.nwu.ac.domain.service.GeneralResponse;

//extends ResponseEntityExceptionHandler

public class ExceptionResponseHandler  {

    //@ExceptionHandler(value = {RuntimeException.class})
    //private ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){
        //ErrorResponse errorRespnse = new ErrorResponse(ex.getMessage());
       // GeneralResponse<ErrorResponse> generalResponse = new GeneralResponse<>(false,errorRespnse);
       // ResponseEntity<GeneralResponse<ErrorResponse>> response = new ResponseEntity<>(generalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        //return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    //}
}
