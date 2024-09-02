package com.thc.rabbitmq.dto;

import java.math.BigDecimal;

public record PagamentoDTO(String numeroPedido, BigDecimal valor, String produto) {
}
