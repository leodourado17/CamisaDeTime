# CamisaDeTime
API do projeto CamisaDeTime - Camisas De Time
## Tarefas

- [ ] CRUD de Modelos
- [ ] CRUD de Ligas
- [ ] CRUD de Times
- [ ] CRUD de Usuários

## Documentação da API

### Endpoint
- [Listar Todos os Modelos](#listar-todos-os-modelos)
- [Cadastrar Modelo](#cadastrar-modelo)
- [Detalhes da modelo](#detalhes-do-modelo)
- [Apagar Modelo](#apagar-modelo)
- [Atualizar Modelo](#atualizar-modelo)

### Listar Todas os Modelos

`GET` /modelo

Retorna um array com todos os modelos cadastrados
#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Brasileirão",
        "icone": "Brasil"
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados das categorias foram efetuados.
|401|Acesso não identificado. Você deve se autenticar

---

### Cadastrar Modelo

`POST` /modelo

Cria um novo modelo com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Um nome curto para o modelo.
|icone|string|❌|O nome do ícone de acordo com a biblioteca Material Icons

```js
{
    "nome": "Brasileirão",
    "icone": "Brasil"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Brasileirão",
    "icone": "Brasil"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|201|Modelo cadastrado com sucesso
|400|Dados enviados não são válidos. Verifique o corpo da requisição
|401|Acesso não permitido. Você deve se autenticar

---

### Detalhes do Modelo

`GET` /modelo/`{id}`

Retornar os detalhes da categoria com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /categoria/1
{
    "id": 1,
    "nome": "Brasileirão",
    "icone": "Brasil"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados do modelo foram retornados com sucesso
|401|Acesso não permitido. Você deve se autenticar
|404|Não existe modelo com o `id` informado

___

### Apagar Categoria

`DELETE` /modelo/`{id}`

Apaga o modelo com o `id` especificado no parâmetro de path.

#### Códigos de Status

|código|descrição|
|------|---------|
|204|Modelo foi apagado com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe modelo com o `id` informado

___

### Atualizar Modelo

`PUT` /modelo/`{id}`

Altera dos dados do modelo especificada no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Um nome curto para o modelo.
|icone|string|✅|O nome do ícone de acordo com a biblioteca Material Icons

```js
{
    "nome": "Brasileirão",
    "icone": "Brasil"
}
```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Brasileirão",
    "icone": "Brasil"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Modelo alterado com sucesso
|400|Dados enviados não são válidos. Verifique o corpo da requisição
|401|Acesso não permitifo. Você deve se autenticar
|404|Não existe modelo com o `id` informado

---

