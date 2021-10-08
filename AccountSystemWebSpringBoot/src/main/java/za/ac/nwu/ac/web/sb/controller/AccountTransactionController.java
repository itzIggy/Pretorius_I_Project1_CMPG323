package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlow,
                                        @Qualifier("createAccountTransactionFlow")CreateAccountTransactionFlow createAccountTransactionFlow){
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow=createAccountTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "All configured Account Transactions", notes = "Returns list of Account Transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transactions Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll() {
        List<AccountTransactionDto> accountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true,accountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createAccountTransactions")
    @ApiOperation(value="Creates new Account Transaction",notes = "Create a new Account transaction in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Transaction Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> createTransaction(
            @ApiParam(value = "Request to create new account transaction", required = true)
            @RequestBody AccountTransactionDto accountTransactionDto){
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.createTransaction(accountTransactionDto);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*@GetMapping("{memberID}")
    @ApiOperation(value = "Gets Specific account transaction", notes = "Fetches account transaction by MemberID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountMemberID(
            @ApiParam(value = "MemberID that Identifies account transaction.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID) {
        AccountTransactionDto accountTransactionDto = fetchAccountTransactionFlow.getAccountTransactionByMemberID(memberID);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
}
