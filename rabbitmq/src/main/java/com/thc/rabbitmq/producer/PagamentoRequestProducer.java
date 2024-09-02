package com.thc.rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thc.rabbitmq.dto.PagamentoDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar(PagamentoDTO pagamento) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange", // Mesmo nome definido no ADMIN http://localhost:15672/#/exchanges
                "pagamento-request-rout-key", // Rout-key igual foi criado no ADMIN defini o nome dela como 'pagamento-request-rout-key'
//                pagamento.toString() // sem serializar
                objectMapper.writeValueAsString(pagamento)
        );
    }
}
