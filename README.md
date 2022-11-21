# DS META

## Projeto Full Stack da Semana Spring + ReactJS

Este projeto foi desenvolvido no treinamento gratuito de Spring + ReactJS fornecido pela [DevSuperior](http://www.devsuperior.com.br) no período de 14/11/2022 à 20/11/2022.

## Ferramentas utilizadas

* Nodejs 16 e Yarn
* STS (Spring Tool Suite)
* VS Code (com as estensões)
    * IntelliCode
    * ESLint
    * JSX HTML

## Design

Um exemplo do design foi criado no Figma e está disponível nos links:

https://www.figma.com/file/PehiT8Dw4Lv5ioTSULZeRI/DSMeta3

https://www.figma.com/file/Yu2RHFmirHQ4BIVZM2XxY6/DSMeta2

https://www.figma.com/file/EN1zFtk4eY3Jgmpgi9YaMG/DSMeta1

## Front-end

O projeto de front-end foi criado com o `Yarn` utilizando a linha de comando 

```
yarn create vite frontend --template react-ts
```

## Back-end

O projeto de back-end foi criado com o [Spring Initializr](https://start.spring.io/) utilizando as dependências:

* Spring Web
* Spring Data JPA
* H2
* Spring Security

A dependência e o plugin abaixo foram adionados ao POM.xml

```xml
<dependency>
	<groupId>com.twilio.sdk</groupId>
	<artifactId>twilio</artifactId>
	<version>8.31.1</version>
</dependency>
```

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version><!--$NO-MVN-MAN-VER$ -->
</plugin>
```
