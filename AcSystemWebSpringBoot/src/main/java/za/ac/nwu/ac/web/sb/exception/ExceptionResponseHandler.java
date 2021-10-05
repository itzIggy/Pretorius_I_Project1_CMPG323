package za.ac.nwu.ac.web.sb.exception;


public class ExceptionResponseHandler /*extends ResponseEntityExceptionHandler */{

    /*@ExceptionHandler(value = {RuntimeException.class})
    private ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){
        ErrorResponse errorRespnse = new ErrorResponse(ex.getMessage());
        GeneralResponse<ErrorResponse> generalResponse = new GeneralResponse<>(false,errorRespnse);
        ResponseEntity<GeneralResponse<ErrorResponse>> response = new ResponseEntity<>(generalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }*/
}
