# plataforma de automacao de busca de vagas

Automacao para coleta e notificacao de vagas de emprego.

## Visao
O projeto automatiza a captura de vagas em fontes online, aplica deduplicacao e envia notificacoes no Telegram.

## MVP atual
- Coleta automatica de vagas (Gupy)
- Processamento e deduplicacao de vagas
- Persistencia com Spring Data JPA + PostgreSQL
- Enriquecimento com LLM via OpenRouter antes do envio ao Telegram:
  - resumo da descricao preservando requisitos e stacks tecnologicas
  - reescrita em portugues brasileiro, mantendo termos tecnicos em ingles
  - identificacao de vagas de empresas estrangeiras
- Envio de vagas para bot no Telegram
- Execucao recorrente com `@Scheduled`
- Aplicacao publicada em VPS

## Proximos passos
- Adicionar novas fontes (Indeed, LinkedIn e outros portais)
- Melhorar filtros (localizacao, senioridade e tipo de trabalho)
- Evoluir observabilidade (metricas e alertas)
- Interface web para acompanhamento

## Tecnologias
Java 21+, Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, OkHttp, Gson, TelegramBots

## Status
MVP em operacao com coleta, persistencia e notificacao automatica de vagas.

## Contato
Desenvolvido por Lucas Santos


- [GitHub](https://github.com/lucasnsnt)
- [LinkedIn](https://www.linkedin.com/in/lucasnsnt)
- [Instagram](https://instagram.com/lucasnsnt)
- Email: lucasnsntcontato@outlook.com
