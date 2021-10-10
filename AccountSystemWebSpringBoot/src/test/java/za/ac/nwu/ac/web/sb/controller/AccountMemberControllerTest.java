package za.ac.nwu.ac.web.sb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.CreateAccountMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountMemberFlow;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountMemberControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACMEMBER_CONTROLLER_URL = APP_URL + "/account-member";

    @Mock
    private FetchAccountMemberFlow fetchAccountMemberFlow;

    @Mock
    private CreateAccountMemberFlow createAccountMemberFlow;

    @InjectMocks
    private AccountMemberController accountMemberController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(accountMemberController).build();
    }

    @Test
    public void getAll() throws Exception{
        String result = "{\"successful\":true,\"payload\":[{\"memberFname\":\"Ivan\",\"memberLname\":\"Pretorius\",\"memberBalance\":1200.0,\"memberPhone\":\"0797515646\"}]}";

        List<AccountMemberDto> accountMemberDtos = new ArrayList<>();
        accountMemberDtos.add(new AccountMemberDto("Ivan","Pretorius",1200.0,"0797515646"));

        when(fetchAccountMemberFlow.getAllAccountMembers()).thenReturn(accountMemberDtos);

        MvcResult mvcResult = mockMvc.perform(get(String.format("%s/%s",ACMEMBER_CONTROLLER_URL,"/all/account-members"))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountMemberFlow, times(1)).getAllAccountMembers();
        assertEquals(result,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void createAccountMember() throws Exception{
        String result = "{\"successful\":true,\"payload\":{\"memberFname\":\"John\",\"memberLname\":\"Smith\",\"memberBalance\":1000.0,\"memberPhone\":\"0797515646\"}}";
        String input = "{\"memberFname\":\"John\",\"memberLname\":\"Smith\",\"memberBalance\":1000.0,\"memberPhone\":\"0797515646\"}";

        AccountMemberDto accountMemberDto = new AccountMemberDto("John","Smith",1000.0,"0797515646");

        when(createAccountMemberFlow.createAccountMember(eq(accountMemberDto))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post((String.format("%s/%s",ACMEMBER_CONTROLLER_URL,"/createAccountMembers")))
                .servletPath(APP_URL)
                .accept(MediaType.APPLICATION_JSON)
                .content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(createAccountMemberFlow, times(1)).createAccountMember(accountMemberDto);
        assertEquals(result,mvcResult.getResponse().getContentAsString());

    }
}