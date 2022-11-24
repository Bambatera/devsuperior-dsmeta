# Front-end (DSMETA)

O projeto de front-end foi criado com o `Yarn` utilizando a linha de comando 

```
yarn create vite frontend --template react-ts
```

## Componentes externos

Foram adicionados ao projetos os seguintes componentes externos.

### DatePicker

O `DatePicker` é um componente externo utilizado para selecionar Datas em um calendário, sua documentação encontra-se no link: [https://github.com/Hacker0x01/react-datepicker](https://github.com/Hacker0x01/react-datepicker)

Para instalá-lo no projeto o seguinte comando foi executado:

```
yarn add react-datepicker@4.8.0 @types/react-datepicker@4.4.2
```

Para sua utilização são necessários os seguintes imports:

```typescript
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
```

Para utilizar o componente, este código deve ser adicionado:

```typescript
<DatePicker
    selected={new Date()}
    onChange={(date: Date) => {}}
    className="dsmeta-form-control"
    dateFormat="dd/MM/yyyy"
/>
```

### Toastify

O `Toastify` é um componente externo utilizado para exibir mensagens `popup` na aplicação, para ser adicionado ao projeto o comando abaixo deve ser utilizado:

```
yarn add react-toastify@9.0.5
```

Para que o componente possa estar disponível em toda a aplicação, as seguintes importações deverm ser adicionadas ao arquivo `App.tsx`:

```typescript
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
```

## Bibliotecas externas

### Axios

Para acesso facilitado ao backend, a lib Axios foi adicionada ao projeto por meio do comando: 

```
yarn add axios@0.27.2
```

## Deploy no Netlify

Para realizar o deploy no Netlify, uma variável de ambiente deve ser criada no servidor, de forma a apontar para o projeto do backend implantado no Heroku, da seguinte forma:

```properties
VITE_BACKEND_URL=https://dsmeta-bambatera.herokuapp.com
```
