package sample.consul;

import com.ijpay.alipay.AliPayApiConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayConfig {

    @Bean
    public AliPayApiConfig getConfig() {
        return AliPayApiConfig.builder()
                .setAppId("2016080700189136")
                .setServiceUrl("https://openapi.alipaydev.com/gateway.do")
                .setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCmVxJ6mc+fH/tTUPng5NBLVjZSzRDoNkAjFOu5UK2ujc1wsvTKHjtc1wzlQuKDfB5Q4qjFehp3e6wrxKz8E12V2gnn0/RK059VgdBOpY3+1+iy/TbuVm5yHPYKbSVPaTJXnLZnsoU4DXIquZx43TlSOXYGetHl7TR4HKEopLSI+Nqk3AqlI+EmbOShCKHfz7hR8XsvpSjB/jKE1tbkAlgvMbWVb9KV8/qFtnPRUXQ2+oH9wmY5m4PCma9p/BBpOqwp+ptpwtRsvOcK/DnYdkM267qTTUNmelxRHQOl1Se0aCBgP+7/FL3nVj/Z8NUFRD85EAXeyR9tVeipy3fWUpErAgMBAAECggEAOwLU6W27vIYKEWq+20wRoUh6iTF6+AaXBlsbrWiz1SM1aO/z6+iBwtQAHS13UpIr5yIiIbzJuu3DDNv/SoZMQydRME9/cTRWaG1fSydskqZiRW2TmUZMdGtV1ikWfW+ijnZoN62bmWEbyZCDtFU3SrZb6ryTznAylxIBEnwsGBMuG1ABqWhVksIJCtlatZkceFVnHDEX/dpx1LlY1aVwJUSga97DBk9lt1IuSVG5yj0/ewXDy5ApIwkitU5khnkfUjr1T67acGczqcYOQ8NujBuvp4+WoRw+N1obQg2pc0SrFnUizlw/bbPFcFrcT6Ia2KdUEi6VLwJH/F8T6Dd5UQKBgQDeUUi3D9TsWrJotwoyZZaRH2HEU24XKRV2xaWEDqINx9kRHTvoJZ2CpVwP5I3H415D+2hzCJ/GVbzOSqX3/rZI5t5xUqJK9PuErtel1YZH7of1DqVzOAghugqB+qeRZ3UvuWWTrzVOdGKtkG3nEAjSxlsg9YOFUpHhVoeWR607vQKBgQC/iqwLwWrkBoIW01n2McvnV1xYIM9SyuSkD5SJCh1Y+WJmwoMpTGTeux2oyqckoWafeTAOWev8osS5gDgEDwWLz5UGAxXxe8oPWaKx5YrEbqkZDdX320LpfUgT//NjxePJC3HZyXxoLrcyqxuCWv0p3mPNkuV2i1h28fC/MH0bBwKBgQCYIqfQHlVnKOnOHvQraLmQthkBcNZ1ove9P6P0qs7a/1fcDlVgl90h+mb1uUIM99saSoE/tzcfUqzRvuO0wemcGeE/S30kLmGwerW4Fla+As2nNU6jekSWT+nA6Pai2lmnPwfz+IJSHfMpMx0CckaXdoYGF/zYz5hkzAIdJQ+3QQKBgHhGmsxy8y0mzQ+KPgZztIebevg3+hgSIcrHocz/1ffl+Z1vbS9Esl6Ofwxb3OMKmsdvMPcCDkbA6ulVE1exGxl1Cy4QR/owcmx7K8erzRyWJIcAAik2vOija9xrL6mqPOQk1KQeeoltNEqT2Z1ch3aAGImhQYfT7oQaXsOfrh+HAoGAb13HaJXAV+Q59VKH1NQIks9lI0tFl3LCFW4BPqwFmu+CHDh7J8ZzKvhTN2qb6fYN7yDomlgzF8EBJxObvRLJiYTGyPYelZuv3qbsPFnk1w6IaAup/iUiSNMYSmPDEZ3lQGc1a/V2nxcSsqpXhsa4eI41igOez41wbz8AyskC55o=")
                .build();
    }
}
