package codeclowns.planny.planny.api;

import codeclowns.planny.planny.constant.BasicApiConstant;
import codeclowns.planny.planny.constant.LoginStatus;
import codeclowns.planny.planny.constant.RegisterStatus;
import codeclowns.planny.planny.data.dto.AccountDto;
import codeclowns.planny.planny.data.entity.AccountE;
import codeclowns.planny.planny.data.mgt.ResponseObject;
import codeclowns.planny.planny.service.AccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-public/account")
@RequiredArgsConstructor
@Slf4j
public class AccountApi {
    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseObject<?> doPostRegister(@RequestBody AccountDto accountDto) {
        var response = new ResponseObject<>();
        try {
            var status = accountService.register(accountDto);
            if (status.equals(RegisterStatus.SUCCEED)) {
                response.setStatus(BasicApiConstant.SUCCEED.getStatus());
                response.setMessage(status.getStateDescription());
            } else {
                response.setStatus(BasicApiConstant.FAILED.getStatus());
                response.setMessage(status.getStateDescription());
            }
        } catch (Exception e) {
            response.setStatus(BasicApiConstant.ERROR.getStatus());
            response.setMessage(RegisterStatus.ERROR.getStateDescription());
        }
        return response;
    }
}
