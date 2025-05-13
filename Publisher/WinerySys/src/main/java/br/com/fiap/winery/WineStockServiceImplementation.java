package br.com.fiap.winery;

import jakarta.jws.WebService;


@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    public String getMenu() {
        return "Menu de Vinhos:\n" +
               "- Merlot\n" +
               "- Cabernet Sauvignon\n" +
               "- Pinot Noir\n" +
               "- Chardonnay\n" +
               "- Sauvignon Blanc\n";
    }

    @Override
    public String placeOrder(String name, int quantity) {
        return "Pedido confirmado! Você solicitou " 
               + quantity + " garrafa(s) de '" + name + "'.";
    }
}
