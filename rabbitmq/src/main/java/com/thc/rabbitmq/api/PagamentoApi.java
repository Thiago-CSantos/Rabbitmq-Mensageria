package com.thc.rabbitmq.api;

import com.thc.rabbitmq.dto.PagamentoDTO;
import com.thc.rabbitmq.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PagamentoApi {

    @Autowired
    private PagamentoFacade pagamentoFacade;

    @PostMapping("pagamento")
    public String processar(@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }


}
