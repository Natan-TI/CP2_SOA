package br.com.fiap.winery;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        System.setProperty(
          "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize",
          "true"
        );
        URL wsdlUrl = new URL("http://localhost:8085/WineStockService?wsdl");
        QName serviceName = new QName(
          "http://winery.fiap.com.br/",
          "WineStockServiceImplementationService"
        );
        Service service = Service.create(wsdlUrl, serviceName);
        WineStockService port = service.getPort(WineStockService.class);
        String order = port.placeOrder("Merlot", 3);
        System.out.println(order);
        
        URL wsdlWarn = new URL("http://localhost:8086/WineWarningService?wsdl");
        QName qNameWarn = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
        Service serviceWarn = Service.create(wsdlWarn, qNameWarn);
        WineWarningService warnPort = serviceWarn.getPort(WineWarningService.class);
        String warn = warnPort.sendWarn();
        System.out.println(warn);
    }
}
