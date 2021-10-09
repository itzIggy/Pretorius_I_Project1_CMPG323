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
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;

import java.util.List;

@RestController
@RequestMapping("account-member")
public class AccountMemberController {

    private final FetchAccountMemberFlow fetchAccountMemberFlow;
    private final CreateAccountMemberFlow createAccountMemberFlow;
    private final ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public AccountMemberController(FetchAccountMemberFlow fetchAccountMemberFlow,
                                   @Qualifier("createAccountMemberFlowName")CreateAccountMemberFlow createAccountMemberFlow,
                                   @Qualifier("modifyMemberFlow")ModifyMemberFlow modifyMemberFlow){
        this.fetchAccountMemberFlow = fetchAccountMemberFlow;
        this.createAccountMemberFlow = createAccountMemberFlow;
        this.modifyMemberFlow=modifyMemberFlow;
    }

    @GetMapping("/all/account-members")
    @ApiOperation(value = "All configured Account Members", notes = "Returns list of Account Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Members Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountMemberDto>>> getAll() {
        List<AccountMemberDto> accountMembers = fetchAccountMemberFlow.getAllAccountMembers();
        GeneralResponse<List<AccountMemberDto>> response = new GeneralResponse<>(true,accountMembers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createAccountMembers")
    @ApiOperation(value="Creates new Account Member",notes = "Create a new Account Member in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Member Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountMemberDto>> createAccountMember(
            @ApiParam(value = "Request to create new account member", required = true)
            @RequestBody AccountMemberDto accountMemberDto){
        AccountMemberDto accountMembers = createAccountMemberFlow.createAccountMember(accountMemberDto);
        GeneralResponse<AccountMemberDto> response = new GeneralResponse<>(true,accountMembers);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getAccountMember/{memberID}")
    @ApiOperation(value = "Gets Specific account member", notes = "Fetches account member by memberFname")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Member Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountMemberDto>>> getAccountMember(
            @PathVariable("memberID") final Long memberID) {
        List<AccountMemberDto> accountMemberDto = fetchAccountMemberFlow.getAccountMemberByMemberID(memberID);
        GeneralResponse<List<AccountMemberDto>> response = new GeneralResponse<>(true, accountMemberDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/editAccountMember")
    @ApiOperation(value = "Modifies Account Member",notes = "Modifies an account member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account member Found",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountMemberDto>> modifyAccountMember(
            @RequestBody AccountMemberDto accountMember){
        AccountMemberDto accountMemberDto = modifyMemberFlow.modifyAccountMember(accountMember);
        GeneralResponse<AccountMemberDto> response = new GeneralResponse<>(true,accountMemberDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/addToBalance/{memberID}/{balance}")
    @ApiOperation(value = "Add Currency to Member balance",notes = "Adds to Balance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account member balance updated",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountMemberDto>> addCurrencyToBalance(
            @PathVariable("memberID") Long memberID,
            @PathVariable("balance") double balance){
        AccountMemberDto accountMemberDto = modifyMemberFlow.addCurrencyToBalance(memberID,balance);
        GeneralResponse<AccountMemberDto> response = new GeneralResponse<>(true,accountMemberDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/subtractFromBalance/{memberID}/{balance}")
    @ApiOperation(value = "Subtract Currency to Member balance",notes = "Subtract to Balance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account member balance updated",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountMemberDto>> subtractFromBalance(
            @PathVariable("memberID") Long memberID,
            @PathVariable("balance") double balance){
        AccountMemberDto accountMemberDto = modifyMemberFlow.subtractCurrencyFromBalance(memberID,balance);
        GeneralResponse<AccountMemberDto> response = new GeneralResponse<>(true,accountMemberDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
