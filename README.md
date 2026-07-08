Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!

# API de Vendas Integrada à API de Funcionários

## 📌 Sobre o Projeto

Este projeto consiste em duas APIs REST desenvolvidas com **Spring Boot**:

- **API de Funcionários**
- **API de Vendas**

A proposta é demonstrar a comunicação entre microsserviços utilizando requisições HTTP.

A API de Vendas consome a API de Funcionários para obter os dados do funcionário responsável por uma venda antes de persisti-la em seu próprio banco de dados.

---

# 📚 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Swagger (OpenAPI)

---

# 🏗 Arquitetura

```
                +----------------------+
                |      Cliente         |
                +----------+-----------+
                           |
                    POST /vendas
                           |
                           ▼
               +----------------------+
               |     API Vendas       |
               |      Porta 8081      |
               +----------+-----------+
                          |
          GET /funcionarios/{id}
                          |
                          ▼
              +-----------------------+
              | API Funcionários      |
              |      Porta 8080       |
              +-----------+-----------+
                          |
                          ▼
                  Banco H2 Funcionários

                          ▲
                          |
                          ▼

                  Banco H2 Vendas
```

---

# 🎯 Objetivo

Ao cadastrar uma venda, a API deve:

- Receber os dados da venda.
- Receber o ID do funcionário.
- Consultar a API de Funcionários.
- Recuperar os dados do funcionário.
- Copiar essas informações para a venda.
- Salvar tudo no banco da API de Vendas.

---

# 📂 Estrutura do Projeto

```
src
 └── main
     ├── java
     │    └── org.example
     │         ├── config
     │         ├── controller
     │         ├── dto
     │         ├── models
     │         ├── repository
     │         ├── service
     │         └── ApiVenda
     │
     └── resources
           └── application.properties
```

---

# 📁 Descrição das Classes

## ApiVenda

Classe principal da aplicação.

Responsável por iniciar o Spring Boot.

---

## AppConfig

Classe de configuração do Spring.

Cria um Bean do tipo `RestTemplate`, utilizado para realizar chamadas HTTP para outras APIs.

---

## VendaController

Responsável pelos endpoints REST da aplicação.

Disponibiliza:

- GET
- POST
- PUT
- DELETE

As requisições recebidas são encaminhadas para a camada de serviço.

---

## VendaService

Responsável pela regra de negócio.

Principais funções:

- Buscar vendas
- Buscar venda por ID
- Atualizar venda
- Excluir venda
- Cadastrar nova venda
- Consumir a API de Funcionários
- Tratar possíveis erros de comunicação

Durante o cadastro de uma venda:

1. Recebe um `VendaRequestDTO`.
2. Consulta a API de Funcionários.
3. Obtém os dados do funcionário.
4. Copia essas informações para a entidade Venda.
5. Persiste a venda no banco de dados.

---

## VendaRepository

Interface responsável pelo acesso ao banco.

Estende:

```java
JpaRepository<Venda, Integer>
```

Disponibiliza automaticamente métodos como:

- save()
- findAll()
- findById()
- deleteById()

---

## Venda

Entidade responsável por representar uma venda no banco de dados.

Além dos dados da venda, também armazena:

- funcionário
- telefone
- email
- endereço
- cidade
- salário
- data de nascimento
- data de cadastro

Esses dados são copiados da API de Funcionários.

---

## FuncionarioDTO

DTO utilizado para receber os dados retornados pela API de Funcionários.

Representa apenas o contrato de comunicação entre as duas APIs.

---

## VendaRequestDTO

DTO utilizado para receber os dados enviados pelo cliente.

Contém:

- descrição
- data
- produto
- valor
- quantidade
- funcionarioId

---

## application.properties

Arquivo responsável pelas configurações da aplicação.

Exemplos:

- Porta da aplicação
- Banco H2
- Configuração JPA
- Console H2

---

# 🔄 Fluxo de Cadastro da Venda

```
Cliente
    │
    ▼
POST /vendas
    │
    ▼
VendaController
    │
    ▼
VendaService
    │
    ├──────────────► GET /funcionarios/{id}
    │
    │               API Funcionários
    │                     │
    │                     ▼
    │           Dados do Funcionário
    │
    ▼
Cria objeto Venda
    │
    ▼
Copia dados do funcionário
    │
    ▼
Salva no banco H2
    │
    ▼
Retorna a venda cadastrada
```

---

# 🚨 Tratamento de Erros

Durante a integração foram implementados tratamentos para:

## API de Funcionários indisponível

Caso a API não esteja em execução:

```
API de Funcionários indisponível.
```

---

## Funcionário inexistente

Caso o ID informado não exista:

```
Funcionário com ID X não encontrado.
```

Também é realizada validação para impedir o cadastro de uma venda sem um funcionário válido.

---

# 📬 Exemplo de Cadastro

## Requisição

```http
POST /vendas
```

```json
{
  "descricao": "Venda de Notebook",
  "dataVenda": "10/06/2026",
  "nomeProduto": "Notebook Dell",
  "valorProduto": 3500,
  "qtd": 2,
  "funcionarioId": 1
}
```

---

## Resposta

```json
{
  "id": 1,
  "descricao": "Venda de Notebook",
  "dataVenda": "10/06/2026",
  "nomeProduto": "Notebook Dell",
  "valorProduto": 3500.0,
  "qtd": 2,
  "valorTotalVenda": 7000.0,
  "funcionarioId": 1,
  "funcionarioNome": "Jesus",
  "funcionarioTelefone": "string",
  "funcionarioEmail": "string",
  "funcionarioEndereco": "string",
  "funcionarioCidade": "string",
  "funcionarioSalario": 0.0,
  "funcionarioDataNasc": "string",
  "funcionarioDataCadas": "string"
}
```

---

# ▶️ Como Executar

## 1. Inicie a API de Funcionários

```
localhost:8080
```

---

## 2. Cadastre um funcionário

```
POST /funcionarios
```

---

## 3. Inicie a API de Vendas

```
localhost:8081
```

---

## 4. Cadastre uma venda

```
POST /vendas
```

Informando um `funcionarioId` válido.

---

# ✅ Resultado

Ao cadastrar uma venda:

- A API consulta a API de Funcionários.
- Recupera os dados do funcionário.
- Armazena uma cópia dessas informações junto com a venda.
- Persiste tudo no banco H2 da API de Vendas.

---

# 👨‍💻 Autor

**Thales Enrico**

Projeto desenvolvido para demonstrar integração entre APIs REST utilizando Spring Boot, consumo de serviços HTTP com `RestTemplate` e persistência de dados utilizando H2 Database.
