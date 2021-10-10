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
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
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
public class AccountTypeControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACT_CONTROLLER_URL = APP_URL + "/account-type";

    @Mock
    private FetchAccountTypeFlow fetchAccountTypeFlow;

    @Mock
    private CreateAccountTypeFlow createAccountTypeFlow;

    @InjectMocks
    private AccountTypeController accountTypeController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(accountTypeController).build();
    }

    @Test
    public void getAll() throws Exception{
        String result = "{\"successful\":true,\"payload\":[{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles\",\"creationDate\":[2020,2,2]}]}";

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES","Miles",LocalDate.parse("2020-02-02")));

        when(fetchAccountTypeFlow.getAllAccountTypes()).thenReturn(accountTypeDtos);

        MvcResult mvcResult = mockMvc.perform(get(String.format("%s/%s",ACT_CONTROLLER_URL,"/all"))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountTypeFlow, times(1)).getAllAccountTypes();
        assertEquals(result,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void create() throws Exception{
        String result = "{\"successful\":true,\"payload\":{\"mnemonic\":\"WON\",\"accountTypeName\":\"Won\",\"creationDate\":[2020,10,1]}}";
        String input = "{\"mnemonic\":\"WON\",\"accountTypeName\":\"Won\",\"creationDate\":[2020,10,1]}";

        AccountTypeDto accountTypeDto = new AccountTypeDto("WON","Won",LocalDate.parse("2020-10-01"));

        when(createAccountTypeFlow.createAccountType(eq(accountTypeDto))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post((String.format("%s/%s",ACT_CONTROLLER_URL,"/createAccountType")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(createAccountTypeFlow, times(1)).createAccountType(accountTypeDto);
        assertEquals(result,mvcResult.getResponse().getContentAsString());
    }
}