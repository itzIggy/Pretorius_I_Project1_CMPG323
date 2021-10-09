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
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.RemoveAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private final ModifyAccountTypeFlow modifyAccountTypeFlow;
    private final RemoveAccountTypeFlow removeAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow,
                                 @Qualifier("modifyAccountTypeFlow") ModifyAccountTypeFlow modifyAccountTypeFlow,
                                 @Qualifier("removeAccountTypeFlow")RemoveAccountTypeFlow removeAccountTypeFlow) {
        this.removeAccountTypeFlow =removeAccountTypeFlow;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
        this.modifyAccountTypeFlow = modifyAccountTypeFlow;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true,accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createAccountType")
    @ApiOperation(value="Creates new Account Type",notes = "Create a new Account type in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Type Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request to create new account type", required = true)
            @RequestBody AccountTypeDto accountType) {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.createAccountType(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getAccountTypeBy/{mnemonic}")
    @ApiOperation(value = "Gets Specific account type", notes = "Fetches account type by Mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountMnemonic(
            @ApiParam(value = "Mnemonic that Identifies account type.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {
        AccountTypeDto accountTypeDto = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/editAccountType")
    @ApiOperation(value = "Modifies Account type",notes = "Modifies an account type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type Found",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> modifyAccountType(
            @RequestBody AccountTypeDto accountType){
        AccountTypeDto accountTypeDto = modifyAccountTypeFlow.modifyAccountType(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountTypeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/removeAccountTypeBy/{accountTypeID}")
    @ApiOperation(value = "Deletes Account type",notes = "Deletes an account type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type Deleted",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> removeAccountType(
            @PathVariable("accountTypeID") final Long accountTypeID){
        removeAccountTypeFlow.removeAccountTypeByID(accountTypeID);
        GeneralResponse<String> response = new GeneralResponse<>(true, "Removed");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
