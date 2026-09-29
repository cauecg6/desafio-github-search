# GitHub Search

App Android que salva um usuário do GitHub e lista todos os repositórios públicos dele.
Projeto do desafio do curso de Android da [DIO](https://www.dio.co).

- Repositório original do desafio: https://github.com/digitalinnovationone/desafio-github-search
- Minha solução: https://github.com/cauecg6/desafio-github-search

## Objetivo

Criar um app simples que armazene um usuário do GitHub (informado na tela inicial) e liste seus
repositórios públicos, mantendo o usuário salvo e permitindo trocá-lo.

## Funcionalidades

- Digitar um usuário do GitHub e confirmar
- Usuário salvo no aparelho: ao abrir o app de novo, ele já aparece e a lista é carregada
- Trocar de usuário a qualquer momento
- Lista de repositórios públicos do usuário
- Tocar em um repositório abre o link no navegador
- Botão de compartilhar o link do repositório
- Tratamento de erros com mensagens amigáveis: campo vazio, usuário inexistente,
  sem internet, usuário sem repositórios
- Indicador de carregamento (ProgressBar) e teclado escondido ao confirmar
- Textos no `strings.xml`

## Conceitos usados

- **SharedPreferences**: guarda o nome do usuário para o app lembrar dele
- **Retrofit + GsonConverterFactory**: chamada à API `https://api.github.com/users/{user}/repos`,
  com `enqueue` e `Callback` para tratar sucesso e falha sem travar a tela
- **RecyclerView + Adapter + ViewHolder**: lista dos repositórios
- **Intents**: `ACTION_SEND` para compartilhar e `ACTION_VIEW` para abrir o navegador
- **findViewById**, `strings.xml` e permissão `INTERNET` no `AndroidManifest.xml`

## Estrutura

```
app/src/main/java/br/com/igorbag/githubsearch/
├── data/GitHubService.kt        # interface do Retrofit
├── domain/Repository.kt         # modelo do repositório
└── ui/
    ├── MainActivity.kt
    └── adapter/RepositoryAdapter.kt
```

## Como rodar

1. Instale o [Android Studio](https://developer.android.com/studio)
2. Clone o repositório: `git clone https://github.com/cauecg6/desafio-github-search.git`
3. Abra a pasta no Android Studio e aguarde o Gradle sincronizar
4. Rode em um emulador ou celular (`Run > Run 'app'`)
5. Digite um usuário, por exemplo `google`, e toque em **Confirmar**

Pelo terminal (Windows), com JDK 17 ou 21: `gradlew.bat assembleDebug`

> Observação: atualizei Gradle (8.9), AGP (8.5.2) e Kotlin (1.9.24) porque as versões
> originais não rodam em JDKs mais novos. `compileSdk` e `targetSdk` continuam em 32.

## Prints

<!-- Coloque seus prints em uma pasta "prints/" e referencie assim: ![Tela inicial](prints/tela-inicial.png) -->

| Tela inicial | Lista de repositórios | Erro |
|:---:|:---:|:---:|
| _print aqui_ | _print aqui_ | _print aqui_ |
