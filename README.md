<h1 align="center">
    <b>Bomtrato</b>
</h1>

</p>

## 💻 Teste Técnico
Montar um serviço back-end, do tipo API REST, com um CRUD básico e com persistência de dados. Além disso, implementar o módulo de aprovações de 
processos nessa plataforma.


## 🚀 Tecnologias

* Java 11
* Banco de Dados Relacional MySQL 8.0
* Spring Framework
* Dependencias Spring
- Spring Web
- Spring Boot DevTools 
- Spring Data JPA
- MySQL Driver
- Validation 


## Implementações
O aprovador pode:
* Cadastrar processos
* Editar processos
* Visualizar processos
* Aprovar processos

Usuario pode:
* Cadastrar novos usuarios
* Buscar usuarios por id
* Buscar usuarios por nome completo
* Deletar usuario

## Informações adicionais
* Não é possivel a inserção de valores abaixo de R$ 30.000
* Só é possivel inserir 50 caracteres, contemplando apenas letras no campo de 'escritório'
* Só é possivel inserir 100 caracteres, contemplando apenas letras no campo de 'reclamante'
* Possuo uma camada de segurança onde é necessario um token de autentificação para ultilização da maioria dos métodos.

## ⚠️ Atenção: 
- No application properties necessário configurar Usuário e Senha para criar o banco de dados!
- Realizei testes dos endpoints via Postman e a collection está disponível neste repositório.
