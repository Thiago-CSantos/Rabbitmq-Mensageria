package com.thc.rabbitmq.consumer;

import com.thc.rabbitmq.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PagamentoResponseSucessoConsumer {
    @Autowired
    private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = "pagamento-request-sucesso-queue")
    public void receive(@Payload Message message) {
        String payLoad = String.valueOf(message.getPayload());
        pagamentoFacade.sucessoPagamento(payLoad);
    }
}
