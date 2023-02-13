# Parking API

Este é um sistema que faz parte do conjunto de projetos práticos oferecidos pela plataforma da empresa [DIO](https://www.dio.me/). Foi desenvolvida uma API REST, criada com o Spring Boot, para o gerenciamento de um estacionamento, contendo as quatro operações básicas de armazenamento persistente - Create, Read, Update, Delete (CRUD). Além disso, também foi criada uma operação denominada *checkout*, que retorna o valor a ser pago no estacionamento de acordo com uma regra de negócio que realiza o seguinte cálculo: há um valor fixo de R$ 20,00 para até 1 hora de uso do estacionamento. A partir desse limite, o sistema adiciona R$ 0,25 para cada minuto passado.

A API foi documentada utilizando a biblioteca OpenAPI do java. Além disso, foi implementada segurança na aplicação, por meio do método básico de autorização e autenticação do Spring Security. Foram cadastrados dois usuários no banco de dados de forma manual, um com a *role admin* e outro com a *role user*. Dessa forma, por meio de configurações de segurança e anotações, foi definido qual ou quais recursos cada um conseguiria acessar. Posteriormente serão desenvolvidos *endpoints* para cadastrar os usuários e definir suas *roles* para acessar a aplicação. 

O banco de dados utilizado foi o Postgres. Todo seu gerenciamento, criação e interação, ocorreu utilizando-se um container docker. Para criação, foi utilizado o seguinte comando:

```bash
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres	
```

Para acessar o banco de dados:

```bash
docker exec -it <CONTAINER ID> bash
```

Para interagir com o banco de dados, em vez de utilizar uma ferramenta gráfica, como o pgAdmin, optou-se por utilizar o psql, que é um cliente do PostgreSQL e pode ser utilizado no próprio terminal:

```bash
psql -h localhost -p 5432 -U admin parking
```

## Tecnologias utilizadas:

* Linguagem de programação: Java 19;
* Spring Framework;
* Sistema Operacional: Ubuntu 22.04.1 LTS;
* Versionamento: Git/GitHub;
* IDE: IntelliJ Community;
* Testes da API: Postman;
* Docker;

## Dependências utilizadas:
* Spring Web;
* Spring Boot DevTools;
* Lombok;
* Spring Data JPA;
* PostgreSQL Driver;
* ModelMapper;
* OpenAPI 3;
* Spring Secutiry;
* Validation;