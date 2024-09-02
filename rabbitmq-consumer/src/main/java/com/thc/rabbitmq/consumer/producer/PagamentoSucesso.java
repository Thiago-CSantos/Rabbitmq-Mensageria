package com.thc.rabbitmq.consumer.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSucesso {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarRespota(String mensagem) {
        amqpTemplate.convertAndSend(
                "pagamento-request-sucesso-exchange",
                "pagamento-request-sucesso-rout-key",
                mensagem
        );
    }
}
