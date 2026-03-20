# TCG Cards API

API REST desenvolvida com Spring Boot para gerenciamento de cartas de TCG (Trading Card Game).

O sistema permite cadastrar, listar, atualizar e remover cartas, contendo nome e raridade.

---

## Tecnologias utilizadas

* Java 25
* Spring Boot 4
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Gradle
* Postman (para testes)

---

## Funcionalidades

* Criar carta
* Listar todas as cartas
* Buscar carta por ID
* Atualizar carta
* Deletar carta

---

## Modelo de dados

Cada carta possui:

* **nome** (obrigatório)
* **raridade** (enum)

### Raridades disponíveis:

```json
"N", "R", "SR"
```

---

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/pdrhnr/tcg-cards-api.git
```

---

### 2. Acessar a pasta

```bash
cd tcg-cards-api
```

---

### 3. Configurar banco de dados

Edite o arquivo:

```
src/main/resources/application.properties
```

Com suas credenciais MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cards
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

---

### 4. Rodar a aplicação

```bash
./gradlew bootRun
```

---

## Como testar a API

Os testes foram realizados utilizando o Postman.

### Base URL

```
http://localhost:8080/cards
```

---

### Criar carta

**POST /cards**

```json
{
  "nome": "Carta Teste",
  "raridade": "SR"
}
```

---

### Listar cartas

**GET /cards**

---

### Buscar por ID

**GET /cards/{id}**

---

### Atualizar carta

**PUT /cards/{id}**

```json
{
  "nome": "Carta Teste",
  "raridade": "R"
}
```

---

### Deletar carta

**DELETE /cards/{id}**

---

## Tratamento de erros

A API possui tratamento global de erros, retornando mensagens padronizadas para:

* Dados inválidos
* Campos obrigatórios
* Valores incorretos de raridade

---

## Estrutura do projeto

```
src/
 ├── controller
 ├── dto
 ├── exception
 ├── model
 │    ├── entity
 │    └── repositories
