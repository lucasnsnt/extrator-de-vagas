# plataforma de automação de busca de vagas

Automacao para busca, filtragem e acompanhamento de vagas de emprego, com foco em pipeline de coleta, deduplicacao e evolucao para personalizacao de curriculo e notificacao.

## Visao
O objetivo do projeto e automatizar a busca de vagas em multiplos sites, filtrar por palavras-chave,
evitar duplicidades e evoluir para personalizacao de curriculo com LLM e notificacoes via Telegram.

## Features Implementadas
- Estrutura de entidades para vagas e fontes
- Repositorios Spring Data JPA para persistencia
- Servico de processamento com:
  - normalizacao de texto
  - geracao de hash para deduplicacao de vagas
  - associacao de fonte por vaga
- Scraper funcional da Gupy com consumo de API e mapeamento para entidades
- Agendamento automatico de coleta com `@Scheduled`
- Persistencia local em memoria para desenvolvimento

## Em Andamento
- Ajustes de robustez para deduplicacao de `JobSource` em cenarios repetidos/concorrentes
- Refino de logs e tratamento de erros no fluxo de processamento

## Features Planejadas
- Scrapers adicionais (Indeed, LinkedIn e outros portais)
- Filtros mais ricos (localizacao, senioridade e tipo de trabalho)
- Personalizacao automatica de curriculo com LLM
- Geracao de curriculo em PDF
- Notificacao via Telegram
- Interface web para visualizacao e controle
- Migracao para banco persistente de producao (ex.: PostgreSQL)

## Tecnologias
Java 21+, Spring Boot, Spring Data JPA, Hibernate, H2, OkHttp, Gson, Selenium, HtmlUnit, Thymeleaf, OpenHTMLtoPDF, TelegramBots

## Status
Projeto em desenvolvimento ativo.
A base de coleta e persistencia ja esta funcional (Gupy + Scheduler + JPA), com evolucao em andamento para integracoes e camadas de produto.

## Contato
Desenvolvido por Lucas Santos

- [GitHub](https://github.com/lucasnsnt)
- [LinkedIn](https://www.linkedin.com/in/lucasnsnt)
- [Instagram](https://instagram.com/lucasnsnt)
- Email: lucasnsntcontato@outlook.com
