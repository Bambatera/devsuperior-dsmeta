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
* Heroku CLI (hospedagem na nuvem)
* Postman
* Twilio (SMS)

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

### Componentes externos

#### DatePicker

O DatePicker é um componente externo utilizado para selecionar Datas em um calendário, sua documentação encontra-se no link: [https://github.com/Hacker0x01/react-datepicker](https://github.com/Hacker0x01/react-datepicker)

Para instalá-lo no projeto o seguinte comando foi executado:

```
yarn add react-datepicker@4.8.0 @types/react-datepicker@4.4.2
```

Para sua utilização são necessários os seguintes imports:

```typescript
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
```

O uso padrão para o componente com o código:

```typescript
<DatePicker
    selected={new Date()}
    onChange={(date: Date) => {}}
    className="dsmeta-form-control"
    dateFormat="dd/MM/yyyy"
/>
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

**Obs.:** Após realizar a alteração no `pom.xml` recomenda-se recarregar o arquivo.

### Configurações de Segurança

O projeto necessida da seguinte classe para definir a configuração de segurança, permitindo o acesso CORS.

```java
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
```

