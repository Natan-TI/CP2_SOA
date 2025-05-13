# WinerySys SOAP API - Checkpoint 2

## Descrição do Projeto

Este repositório contém a implementação completa do Checkpoint 2 da disciplina Arquitetura SOA e Web Services, ministrada pelo Prof. Carlos Eduardo Machado de Oliveira na FIAP. O objetivo é demonstrar a publicação de serviços SOAP e o consumo desses serviços em clientes Java.

## Estrutura do Repositório

```
Winery/
├─ Publisher/
│  └─ WinerySys/           # Projeto dos Serviços SOAP (Server)
├─ Consumer/
│  ├─ WineStockClient/     # Cliente SOAP para consultar menu de vinhos
│  └─ WineOrderClient/     # Cliente SOAP para realizar pedidos e receber avisos
└─ README.md               # Este arquivo de documentação
```

## Módulos

### 1. Publisher (WinerySys)
- **WinerySys**: implementa duas interfaces SOAP:
  - `WineStockService` com os métodos `getMenu()` e `placeOrder(name, quantity)`;
  - `WineWarningService` com o método `sendWarn()`.
- O driver `Loader` publica ambos os serviços em:
  - `http://localhost:8085/WineStockService?wsdl`
  - `http://localhost:8086/WineWarningService?wsdl`

### 2. Consumer (WineStockClient)
- Cliente que consome `WineStockService.getMenu()` e imprime o menu de vinhos:
  - Classe principal: `ApplicationClient1`.

### 3. Consumer (WineOrderClient)
- Cliente que consome:
  1. `WineStockService.placeOrder(name, quantity)` para realizar pedidos;
  2. `WineWarningService.sendWarn()` para receber alerta de estoque.
- Classe principal: `ApplicationClient2`.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE opcional: IntelliJ IDEA, Eclipse STS, VS Code

## Instruções de Build e Execução

### 1. Executar o Publisher (WinerySys)
```bash
cd Winery/Publisher/WinerySys
mvn clean compile exec:java -Dexec.mainClass="br.com.fiap.winery.Loader"
```
Isso publica:
- Serviço de estoque:  `http://localhost:8085/WineStockService?wsdl`
- Serviço de aviso:    `http://localhost:8086/WineWarningService?wsdl`

### 2. Executar o WineStockClient
```bash
cd Winery/Consumer/WineStockClient
# via Maven
mvn clean compile exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient1"
# ou via JAR executável
java -Dcom.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize=true \
     -jar target/WineStockClient-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### 3. Executar o WineOrderClient
```bash
cd Winery/Consumer/WineOrderClient
# via Maven
mvn clean compile exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient2"
# ou via JAR executável
java -Dcom.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize=true \
     -jar target/WineOrderClient-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Testes

Cada projeto inclui testes unitários gerados pelo archetype Maven. Para rodar os testes:
```bash
mvn test
```

## Integrantes
<table>
  <tr>
    <td align="center">
        <sub>
          <b>João Pedro Marques Rodrigues - RM98307</b>
          <br>
        </sub>
        <sub>
          <b>Natan Eguchi dos Santos - RM98720</b>
          <br>
        </sub>
        <sub>
          <b>Kayky Paschoal Ribeiro - RM99929</b>
          <br>
        </sub>
    </td>
  </tr>
</table>