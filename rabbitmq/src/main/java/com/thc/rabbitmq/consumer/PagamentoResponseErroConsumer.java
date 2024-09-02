package com.thc.rabbitmq.consumer;

import com.thc.rabbitmq.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumer {

    @Autowired
    private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = "pagamento-request-erro-queue") // para saber qual fila ele vai ficando "ouvindo"
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + " " + LocalDateTime.now());
        String payLoad = String.valueOf(message.getPayload());

        pagamentoFacade.erroPagamento(payLoad);
    }
}
