# 💱 Conversor de Moedas – América Latina - Challenge One G9

Status do Projeto: ✔️ Concluído (versão console)

## 📚 Tópicos

🔹 [Descrição do projeto](#descrição-do-projeto)  
🔹 [Funcionalidades](#funcionalidades)  
🔹 [Layout da Aplicação](#layout-da-aplicação-)  
🔹 [Pré-requisitos](#pré-requisitos)  
🔹 [Como rodar a aplicação](#como-rodar-a-aplicação-️)  
🔹 [Casos de Uso](#casos-de-uso)  
🔹 [Linguagens e tecnologias utilizadas](#linguagens-e-tecnologias-utilizadas-)  
🔹 [Estrutura do projeto](#estrutura-do-projeto-)  
🔹 [Melhorias futuras](#melhorias-futuras)  
🔹 [Desenvolvedores](#desenvolvedorescontribuintes)

---

## Descrição do projeto

O **Conversor de Moedas – América Latina** é uma aplicação de linha de comando desenvolvida em Java que realiza conversões de moedas em tempo real utilizando a **ExchangeRate API**.

O foco do projeto é simular um conversor pensado para usuários da **América Latina**, oferecendo suporte a diversas moedas latino-americanas (como BRL, ARS, COP, CLP, PEN, MXN, VES, entre outras), além de moedas amplamente utilizadas como **USD** e **EUR**.

A interface textual foi implementada em **espanhol**, justamente para refletir esse foco regional e aproximar o uso do conversor da realidade de usuários de diferentes países latino-americanos.

Este projeto foi desenvolvido como parte do desafio de lógica e orientação a objetos em Java do programa ONE G9, com ênfase em:

- consumo de APIs HTTP,
- manipulação de JSON com **Gson**,
- uso de coleções (`Map`),
- organização do código em camadas.

---

## Funcionalidades

✔️ **Conversão em tempo real** entre moedas, utilizando taxas obtidas via ExchangeRate API  
✔️ **Menu interativo em espanhol** no console  
✔️ **Suporte a 20+ moedas**, com foco em países da América Latina (BRL, ARS, COP, CLP, PEN, MXN, VES, etc.), além de USD e EUR  
✔️ **Seleção de moeda de origem e destino** a partir de uma lista numerada  
✔️ **Entrada de valor para conversão** utilizando `Scanner`  
✔️ **Validação de opções do menu** (impede seleção de índices inválidos para as moedas)  
✔️ **Tratamento básico de erros** ao chamar a API (falha de rede, problema com a key, etc.)  
✔️ **Organização em camadas**: cliente HTTP, conversor, domínio (modelos), configuração
✔️ **Validação de escolha de mesma moeda**: se impede a escolha da mesma moeda para origem/destino 

---

## Layout da Aplicação 💨

Esta é uma aplicação **de linha de comando (console)**, sem interface gráfica.

Ao executar o programa, o usuário verá um fluxo semelhante a:

```text
Bienvenido al conversor de monedas 💱

Seleccione una opción:
1) Nueva conversión
0) Salir
Opción: 1

Monedas disponibles:
1) USD
2) EUR
3) BRL
4) ARS
...
23) VES

Elige el número de la moneda de origen: 3
Elige el número de la moneda de destino: 1
Ingrese el valor a convertir: 100

100,00 BRL equivalen a 18,50 USD

```

## Pré-requisitos

✅ **Java 17** ou superior  
✅ **IntelliJ IDEA** (ou outra IDE similar)  
✅ Conta gratuita na **ExchangeRate-API**

## Como rodar a aplicação ▶️

1. **Clone o repositório**:

```bash
git clone https://github.com/seu-usuario/conversor-de-moeda-challenge-one-G9.git
```

git clone https://github.com/seu-usuario/conversor-de-moeda-challenge-one-G9.git

Abra o projeto no IntelliJ

File > Open > selecione a pasta do projeto

Configure a API key

Crie uma key em: https://www.exchangerate-api.com/

Vá em: Run > Edit Configurations...

Crie uma configuração do tipo Application

Aponte para a classe:

br.com.martinperez.conversor.Main
Em Environment variables, adicione:

EXCHANGE_RATE_KEY=SUACHAVEAQUI
Execute

Clique em ▶️ ao lado do método main na classe Main.

Use o menu

Escolha:

opção 1 para nova conversão

moeda de origem

moeda de destino

valor


## Casos de Uso

### 💱 Conversão básica

1. Selecionar “Nueva conversión”
2. Escolher a moeda de origem
3. Escolher a moeda de destino
4. Inserir o valor
5. Obter o resultado em tempo real

### 🌎 Conversões Latino-Americanas

Permite combinações como:

- MXN → USD  
- BRL → ARS  
- COP → EUR  
- PEN → BRL  
- VES → USD  

## Linguagens e tecnologias utilizadas 📚

- **Java 17**  
- **Gson** para manipulação de JSON  
- **java.net.http.HttpClient** para chamadas HTTP  
- **ExchangeRate-API**  
- **IntelliJ IDEA**

## Estrutura do Projeto 🧱

src/
 └── br/com/martinperez/conversor
      ├── Main.java
      ├── config/
      │     └── Config.java
      ├── domain/
      │     ├── ExchangeRateResponse.java
      │     └── SupportedCurrencies.java
      └── service/
            ├── ExchangeRateClient.java
            └── CurrencyConverter.java

## Melhorias Futuras

- 🗣️ Versão em português e inglês   
- 💾 Histórico de conversões  
- 🎨 Interface gráfica (Swing, JavaFX ou web)  
- 🧪 Testes automatizados

## Desenvolvedores/Contribuintes

| [<img src="./assets/foto-martin.jpg" width=115><br><sub>Martín Pérez Tovar</sub>](https://github.com/martinpereztovar) |
| :----------------------------------------------------------------------------------------------------------------------: |


## Licença

The MIT License (MIT)

Copyright ©️ 2025 – Conversor de Moedas


