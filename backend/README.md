# Back-end (DSMETA)

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

## Configurações de Segurança

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

## Banco de Dados

O banco de dados utilizado neste projeto é o **H2**, que foi criado dinamicamente pela classe de entidade [`Sale`](./src/main/java/com/devsuperior/dsmeta/entities/Sale.java) do pacote `com.devsuperior.dsmeta.entities`, e foi populado pelo arquivo [`import.sql`](./src/main/resources/import.sql) existente na pasta `resouces` do projeto.

## Bibliotecas externas

### Twilio

A biblioteca `Twilio` é uma biblioteca que permite o envio de mensagens por meio de SMS.
Para isso um cadastro deve ser efetuado no [site oficial](www.twilio.com), que fornecerá uma chave privada e um número de telefone para envio do SMS eletronicamente, o site também fornece uma ampla documentação e exemplos de uso.

Sua configuração deve ser realizada incluindo no arquivo `application.properties` os seguintes parâmetros:

```properties
twilio.sid=${TWILIO_SID}
twilio.key=${TWILIO_KEY}
twilio.phone.from=${TWILIO_PHONE_FROM}
twilio.phone.to=${TWILIO_PHONE_TO}
```

Essas propriedades são utilizadas na classe [`SmsService`](./src/main/java/com/devsuperior/dsmeta/services/SmsService.java) do pacote `com.devsuperior.dsmeta.services`.

**Observação:** Para uso da biblioteca na IDE, recomenda-se a criação de `variáveis de ambiente` para armazenar os códigos de acesso fornecidos pelo site, neste projeto as seguintes variáveis foram criadas:

* TWILIO_SID
* TWILIO_KEY
* TWILIO_PHONE_FROM
* TWILIO_PHONE_TO

## Implantação no Heroku

Para que o projeto funcione corretamente no Heroku, o arquivo `system.properties` deve ser criado na raiz do projeto, e deve conter a versão do Java utilizado.

```properties
java.runtime.version=17
```

**Observação:** Para o bom funcionamento da API no Heroku, recomenda-se a criação de `variáveis de ambiente` para armazenar os códigos de acesso fornecidos pelo site, e devem possuir os mesmos nomes configurados na aplicação:

* TWILIO_SID
* TWILIO_KEY
* TWILIO_PHONE_FROM
* TWILIO_PHONE_TO
