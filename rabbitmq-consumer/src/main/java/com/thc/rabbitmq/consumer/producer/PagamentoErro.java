package com.thc.rabbitmq.consumer.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErro {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarRespota(String mensagem){
        amqpTemplate.convertAndSend(
                "pagamento-request-erro-exchange",
                "pagamento-request-erro-rout-key",
                mensagem
        );
    }
}
