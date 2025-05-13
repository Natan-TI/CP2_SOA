package br.com.fiap.winery;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
    	
    	System.setProperty(
    		      "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize",
    		      "true"
    		    );
        URL wsdlUrl = new URL("http://localhost:8085/WineStockService?wsdl");

        QName serviceName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        javax.xml.ws.Service service =
                javax.xml.ws.Service.create(wsdlUrl, serviceName);

        WineStockService port = service.getPort(WineStockService.class);

        String menu = port.getMenu();
        System.out.println(menu);
    }
}
