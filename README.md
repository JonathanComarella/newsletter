# JC NEWSLETTER
#### Este projeto é um sistema de newsletter desenvolvido em Spring Boot e Postgress. Ele permite o cadastro de usuários, notícias e o envio de e-mails de forma manual ou automática com um job que roda todo dia às 08:00.

# Comandos para rodar o projeto
Para iniciar o projeto, é necessário ter o Docker e o Docker Compose instalados. Siga os passos abaixo para rodar o projeto:

1. Clone o repositório:
   ```sh
   git clone https://github.com/JonathanComarella/newsletter
   cd jc-newsletter
   ```
2. Execute o Docker Compose:
   ```sh
   docker-compose up --build
   ```

Isso irá iniciar os serviços necessários: PostgreSQL e a aplicação Spring Boot.

# APIs Disponíveis
A aplicação oferece as seguintes APIs:

### 1. Cadastrar um usuário - Endpoint: `POST /client`

Body esperado:
* O campo birthDate é opcional.

```json
   {
      "name": "nome do usuario",
      "email": "email@gmail.com",
      "birthDate": "1990-01-01"
   }
```

### 2. Cadastrar uma notícia - Endpoint: `POST /news`

Body esperado:
* O campo link é opcional.

```json
  {
    "title": "Título da notícia",
    "description": "descrição da notícia",
    "link": "link da notícia"
  }
```

### 3. Disparar e-mails manualmente - Endpoint: `POST /email/manually`

Essa rota simula o job que roda diariamente às 08:00 e dispara os e-mails.
