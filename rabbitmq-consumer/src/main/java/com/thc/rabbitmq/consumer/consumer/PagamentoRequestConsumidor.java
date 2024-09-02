package com.thc.rabbitmq.consumer.consumer;

import com.thc.rabbitmq.consumer.producer.PagamentoErro;
import com.thc.rabbitmq.consumer.producer.PagamentoSucesso;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumidor {

    @Autowired
    private PagamentoErro pagamentoErro;
    @Autowired
    private PagamentoSucesso pagamentoSucesso;

    /// Quando você anota um método com @RabbitListener,
    // você está dizendo ao Spring que esse método deve ser invocado automaticamente
    // sempre que uma mensagem for recebida na fila especificada
    @RabbitListener(queues = "pagamento-request-queue") // Mesma queue criado no ADMIN
    public void receberMessage(@Payload Message message) {
        System.out.println(message);

        // É apenas para simular a respota de um ERRO ou SUCESSO
        if (new Random().nextBoolean()) {

            pagamentoSucesso.gerarRespota("sucesso em processar o PAGAMENTO" + message);
        } else {
            pagamentoErro.gerarRespota("Error ao processar o PAGAMENTO" + message);
        }

    }

}
