# <div align="center">ExchangeCriptoMoedas</div>
**Proposta**: Criar uma exchange de criptomoedas em que fosse possível realizar as seguintes operações: 

1. consultar saldo, 
2. consultar extrato, 
3. depositar,
4. sacar, 
5. comprar criptomoedas, 
6. vender criptomoedas,
7. atualizar cotação,
8. sair

Além disso, a exchange precisa trabalhar com taxas de venda e de compra:
<div align="center">

Moeda | taxaCompra | taxaVenda
--|--|--
Bitcoin | 2% | 3%
Ethereum | 1% | 2%
Ripple | 1% | 1%

</div>

**Ferramentas**: Para desenvolver tal projeto, era necessário usar a linguagem java e utilizar orientação a objetos e utilizar o banco de dados PostgreSQL para guardar informações.

**Banco de dados**: as tabelas que utilizei não possuíam primary key e utilizavam o cpf para conectar as duas tabelas. 


<div align="center">
  
Tabela de investidores:

Dado | tipoDado
--|--|
nome | `character varying`
cpf | `character varying`
senha | `bigint`

Tabela de transacoes:

Dado | tipoDado
--|--|
cpf | `character varying`
data | `timestamp without time zone`
operacao | `character varying`
valor | `double precision`
moeda | `character varying`
cotacao | `double precision[]`
taxa | `double precision`
saldoreal | `double precision`
saldobitcoin | `double precision`
saldoethereum | `double precision`
saldoripple | `double precision`
