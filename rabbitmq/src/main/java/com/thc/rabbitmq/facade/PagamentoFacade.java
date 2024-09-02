package com.thc.rabbitmq.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thc.rabbitmq.dto.PagamentoDTO;
import com.thc.rabbitmq.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {
    @Autowired
    private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDTO pagamentoDto) {

        try {
            producer.integrar(pagamentoDto);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar o pagamento..." + pagamentoDto.numeroPedido() + e.getMessage();
        }

        return "Pagamento aguardando confirmação..." + pagamentoDto.numeroPedido();
    }

    public void erroPagamento(String payLoad) {
        System.err.println("==== RESPOSATA DE ERROR ==== " + payLoad);
    }

    public void sucessoPagamento(String payLoad) {
        System.out.println("=== RESPOSTA DE SUCESSO === " + payLoad);
    }
}
