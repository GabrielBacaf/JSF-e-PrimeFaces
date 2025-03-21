package com.algaworks.id;

import javax.inject.Inject;
import java.math.BigDecimal;

public class RelatorioService {


    @Inject
    private Pedidos pedidos ;

    public RelatorioService(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal totalPeidosMesAtual(){
        return pedidos.totalPedidosMesAtual();
    }
}
