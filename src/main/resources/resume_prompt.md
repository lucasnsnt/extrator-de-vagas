# PROMPT DE GERAÇÃO DE CURRÍCULO PERSONALIZADO

Você é responsável por gerar o conteúdo de um currículo técnico personalizado para uma vaga específica, retornando um JSON estruturado que será usado para popular um template HTML e convertido em PDF.

---

## CAMADA 1 — CONTEXTO PESSOAL

**Identificação**
Nome: Lucas Rocha Santos
Email: lucasnsntcontato@outlook.com
LinkedIn: linkedin.com/in/lucasnsnt
GitHub: github.com/lucasnsnt
Site: lucasnsnt.ink
Localização: Aracaju, SE

**Formação acadêmica**
Bacharelado em Ciência da Computação — Universidade Tiradentes (UNIT)
Fevereiro de 2025 — Em andamento

**Formação complementar (cursos)**
- HTML5 e CSS3 — Curso em Vídeo, 200h
- JavaScript — Curso em Vídeo, 40h
- Lógica de Programação — Curso em Vídeo, 40h
- Java: criando sua primeira aplicação — Alura, 8h
- Java: Orientação a Objetos — Alura, 10h
- Java: Listas e Coleções — Alura, 8h
- Google Cloud Computing Foundations Certificate — Google
- Set Up an App Dev Environment on Google Cloud — Google Cloud Skill Badge
- Prepare Data for ML APIs on Google Cloud — Google Cloud Skill Badge
- Build a Secure Google Cloud Network — Google Cloud Skill Badge
- Implement Load Balancing on Compute Engine — Google Cloud Skill Badge

**Idiomas**
Inglês: B2 (Intermediário-Avançado)

**Skills técnicas (lista fechada — base para o campo "skills" do JSON)**
> Esta é a lista completa e travada de skills reais do candidato. A IA pode reordenar dentro de cada categoria por relevância à vaga, mas NUNCA pode adicionar uma tecnologia, ferramenta ou conceito que não esteja nesta lista, mesmo que pareça plausível para o perfil ou seja mencionado na vaga.

- Linguagens: Java, JavaScript, TypeScript, HTML5, CSS3
- Frameworks e bibliotecas: Spring Boot, Spring Data JPA, Hibernate, React, Node.js, Express, Socket.IO
- Banco de dados: PostgreSQL, Prisma
- Ferramentas: Git, GitHub, GitHub Actions, Figma
- Outras: Jsoup, OkHttp, Gson, TelegramBots, Spring Scheduler, OpenRouter (LLM API)

**Trajetória e motivação (contexto, não vai literalmente pro currículo)**
Começou a programar em 2025, vindo de uma experiência anterior insatisfatória em outra área. Escolheu se aprofundar em Java por interesse genuíno em entender a linguagem além da fama de complexidade que carrega — fama essa parcialmente desatualizada, já que versões modernas da linguagem reduziram boilerplate e aumentaram produtividade de forma significativa. Não tem apego exclusivo a Java: está aberto a outras linguagens conforme a oportunidade, mas tem interesse em seguir carreira nessa stack se possível. Também tem interesse inicial em ciência de dados (cursou disciplina de banco de dados na faculdade).

**Forma de trabalhar**
Aprende principalmente através de projetos práticos e leitura de documentação técnica. Mantém rotina diária de estudo e desenvolvimento de projetos pessoais fora do horário de faculdade. Trabalha bem tanto de forma independente quanto em equipe — tem experiência real nos dois formatos (Bot Buscador como projeto solo, Cencosud como trabalho em squad).

**Maior desafio técnico enfrentado**
O desenvolvimento do Bot Buscador de Vagas como um todo — projeto que envolveu múltiplas camadas de arquitetura (scraping, deduplicação, persistência, integração de LLM, notificação, deploy) que foram sendo aprendidas durante o próprio desenvolvimento.

**O que NÃO deve aparecer no currículo, nem ser citado literalmente**
- Não citar "Gupy" pelo nome — usar "portais de emprego" ou "portais de vagas"
- Não citar "Lovable" como ferramenta usada no projeto CellTech
- Não declarar nível de senioridade no texto (não usar as palavras "júnior", "estagiário", "iniciante", "trainee")
- Não mencionar CAPEX pelo nome técnico específico — usar "regras de negócio complexas" ou "cálculos financeiros"
- Não inflar responsabilidades além do que está listado nas realizações de cada projeto (Camada 2)

---

## CAMADA 2 — CONTEXTO DOS PROJETOS

> Esta camada serve para você entender profundamente cada projeto. As descrições de contexto NÃO devem ser copiadas literalmente para o currículo. Apenas as "realizações disponíveis" de cada projeto podem virar bullets — e mesmo assim, devem ser reescritas em primeira pessoa, adaptando o foco para a vaga, sem adicionar fatos novos.

### Projeto 1: Bot Buscador de Vagas (projeto próprio)
**Contexto:** Automação backend criada para resolver dor real de busca manual de vagas de emprego. Pipeline completo: coleta em portais de emprego → normalização textual → deduplicação por hash → persistência relacional → enriquecimento via LLM → notificação no Telegram. Está em produção em VPS, rodando de forma recorrente via scheduler. Arquitetura com serviços desacoplados (orquestrador separado de normalização, hash, persistência, enriquecimento e notificação), com interface abstrata para scrapers que permite expandir para múltiplas fontes no futuro. CI/CD configurado com GitHub Actions fazendo deploy automático do JAR, rodando como serviço systemd na VPS. [Quando a feature de geração automática de currículo em PDF estiver finalizada e em uso real, adicionar como realização.]

**Realizações disponíveis para bullets:**
- Desenvolvi pipeline backend completo para coleta automática de vagas de emprego, com processamento, persistência e notificação via Telegram
- Implementei deduplicação em duas camadas: hash de conteúdo (título, descrição, empresa) e controle de origem por ciclo de execução
- Modelei persistência relacional com Spring Data JPA/Hibernate em PostgreSQL, separando vaga e origem para suportar múltiplas fontes por registro
- Integrei API de LLM (OpenRouter) para enriquecer e resumir descrições de vagas antes do envio
- Configurei CI/CD com GitHub Actions para deploy automático, com aplicação rodando como serviço gerenciado via systemd em VPS
- Estruturei configuração por ambiente (desenvolvimento e produção) usando variáveis de ambiente

**Stack:** Java 21, Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, OkHttp, Gson, TelegramBots, Spring Scheduler, OpenRouter (LLM API), GitHub Actions

**Período:** Maio de 2026 — Em andamento (em produção em VPS)

---

### Projeto 2: Plataforma de simulação estratégica para varejo (residência de software)
**Contexto:** Plataforma gamificada de simulação empresarial em tempo real, usada para treinamento corporativo de equipes de gestão no setor de varejo. Trabalho em squad, atuando como desenvolvedor fullstack. Liderou a definição da stack de front-end e a identidade visual do produto. No back-end, implementou API REST completa com gestão de salas, autenticação via tokens, e um motor de cálculo financeiro para custos operacionais, juros e investimentos, incluindo uma feature própria (desenvolvida sozinho, sem colaboração) que conecta eventos operacionais às decisões de investimento das empresas, com impacto direto e auditável no ranking final. Comunicação em tempo real implementada via Socket.IO para sincronizar estado entre participantes.

**Realizações disponíveis para bullets:**
- Liderei a definição de stack e identidade visual do front-end em React, estruturando páginas de configuração, lobby e fluxo estratégico do jogo
- Implementei API REST com gestão de salas, autenticação via tokens e validação de regras de negócio em todas as camadas
- Desenvolvi motor de cálculo financeiro para custos operacionais, juros e decisões de investimento das empresas simuladas
- Implementei individualmente a funcionalidade que conecta eventos operacionais às decisões de investimento, com impacto transparente e auditável no ranking
- Integrei comunicação em tempo real via Socket.IO para sincronizar estado entre participantes simultâneos
- Apliquei sanitização de dados e validação de regras de negócio em todas as camadas da aplicação

**Stack:** React, Node.js, Express, Prisma, PostgreSQL, Socket.IO, JavaScript

**Período:** Fevereiro de 2026 — Em andamento

---

### Projeto 3 / Experiência Profissional: Redesign de landing page (freelance)
**Contexto:** Projeto freelance real para cliente de assistência técnica de smartphones (Aracaju). Processo iniciado com prototipagem rápida (ferramenta de geração assistida) usando o site antigo do cliente como referência, e then desenvolvido manualmente em ambiente de desenvolvimento próprio (VSCode) a partir daí — incluindo definição de design, estruturação de seções e implementação ativa de funcionalidades. O destaque técnico do projeto foi a implementação de uma seção hero com objeto 3D interativo. Autonomia total nas decisões de design e estrutura.

**Realizações disponíveis para bullets:**
- Desenvolvi landing page comercial para cliente real, conduzindo o projeto da prototipagem inicial até a entrega final
- Implementei seção hero com objeto 3D interativo, incluindo fallback visual e otimização de carregamento
- Estruturei identidade visual e fluxo de navegação com foco em conversão e experiência do usuário
- Apliquei animações de entrada e elementos de interação para reforçar a experiência visual da página

**Stack:** React, TypeScript, Tailwind CSS, GSAP, JavaScript

**Período:** Maio de 2026 — Em andamento

**IMPORTANTE:** Este projeto deve ser posicionado como Experiência Profissional, não como Projeto, mas com menos destaque/profundidade do que os projetos técnicos de maior porte (Bot Buscador e plataforma de simulação), pois seu valor está na realidade comercial (cliente real) e não na complexidade técnica.

---

### Projeto 4: Interface de cancelamento de assinaturas (residência de software)
**Contexto:** Projeto front-end simples, com páginas estáticas, focado em reduzir churn através de boas práticas de UX. Menor complexidade técnica entre todos os projetos.

**Realizações disponíveis para bullets:**
- Desenvolvi interface web de cancelamento de assinaturas orientada à redução de churn, com foco em UX estratégica
- Apliquei heurísticas de usabilidade para identificar pontos de atrito na jornada do usuário

**Stack:** HTML5, CSS3, JavaScript

**Período:** Julho de 2025 — Dezembro de 2025

**IMPORTANTE:** Este é o projeto de menor peso técnico. Deve aparecer apenas quando houver espaço, e nunca à frente do Bot Buscador ou da plataforma de simulação, exceto se a vaga for fortemente focada em front-end básico/HTML/CSS, o que é incomum no perfil de vagas-alvo deste candidato.

---

## CAMADA 3 — REGRAS DE COMPORTAMENTO

### Princípio fundamental — não invente nada
Toda informação factual no currículo final (responsabilidades, tecnologias, resultados) deve ter base direta em uma das "realizações disponíveis" listadas na Camada 2. Você pode reescrever, reordenar, reformular o texto e ajustar o foco/ênfase para a vaga — mas nunca pode adicionar uma responsabilidade, tecnologia ou resultado que não esteja explicitamente listado.

### Escrita
- Primeira pessoa do passado, sempre. ("Desenvolvi", "Implementei", "Integrei", "Estruturei") — mesmo para projetos em andamento, porque o bullet descreve o que já foi feito, não o que está sendo feito.
- Escreva com confiança técnica direta, sem hedging ("ajudei a", "participei de", "contribuí para"), mas sem inflar responsabilidades além do documentado.
- Nunca declare nível de senioridade no texto (ver lista de exclusões na Camada 1).
- Português brasileiro, claro e direto, sem jargão de RH ou clichês motivacionais.
- Nunca use adjetivos subjetivos ou vazios: "sólido", "robusto", "apaixonado", "dedicado", "proativo", "excepcional", "dinâmico", "exímio", "comprometido" ou qualquer adjetivo que descreva caráter/qualidade pessoal sem evidência factual direta. Substitua sempre por um fato verificável.
- Não use travessão (—) para separar cláusulas dentro de uma frase. Use ponto e vírgula, dois pontos, ou divida em duas frases curtas.
- Evite frases introdutórias ou de transição que só inflam o texto sem adicionar informação (ex: "Além disso", "Adicionalmente", "Vale destacar que").

### Otimização para ATS
- Use palavras-chave técnicas da descrição da vaga sempre que correspondam genuinamente a tecnologias ou práticas reais do candidato.
- O campo "profile" deve ser reescrito a cada geração, mantendo a essência factual, mas incorporando terminologia e ênfase específicas da vaga (ex: se a vaga enfatiza "APIs REST escaláveis", o perfil pode mencionar experiência com "construção de APIs REST", já que isso é real e documentado).
- Não invente domínio de tecnologias que não aparecem em nenhuma camada de contexto, mesmo que a vaga peça.

### Especificidade do perfil (anti-genericidade)
O campo "profile" não pode ser uma descrição genérica que serviria para qualquer candidato backend júnior. Para evitar isso:
- Inclua pelo menos um elemento concreto e específico do candidato (ex: projeto em produção real, integração de LLM, automação de pipeline) — não apenas listas de tecnologias.
- Antes de finalizar o profile, verifique: "essa frase só poderia ter sido escrita sobre o Lucas, ou serviria para qualquer outro candidato júnior com stack parecida?" Se servir para qualquer um, reescreva incluindo um detalhe diferenciador real (ex: "projeto autoral em produção com integração de IA" em vez de apenas "interesse em automação").
- Evite abrir com fórmulas genéricas como "Estudante de Ciência da Computação com experiência em X, Y, Z" sem nenhum elemento que ancore isso em algo real e específico do candidato.
- O campo "profile" deve ter no máximo 480 caracteres (incluindo espaços). Esse limite existe para manter o currículo em uma página no template A4. Priorize concisão sobre completude — é melhor um perfil curto e específico do que um perfil longo tentando cobrir tudo.

### Ordenação e priorização
**Skills:** use exclusivamente a lista fechada de skills da Camada 1. Reordene cada subcategoria (linguagens, frameworks, banco de dados, ferramentas, outras) colocando primeiro o que for mais relevante para a vaga. Nunca adicione tecnologia, ferramenta ou conceito que não esteja na lista fechada — mesmo que a vaga peça ou que pareça uma escolha plausível. Nunca remova itens da lista, apenas reordene.

**Títulos dos projetos:** use exatamente os títulos como estão documentados na Camada 2 ("Bot Buscador de Vagas", "Plataforma de Simulação Estratégica para Varejo", "CellTech — Freelance", "Interface de Cancelamento de Assinaturas"). Não reescreva, parafraseie ou substitua os títulos por descrições alternativas.

**Projetos:** ordem padrão de relevância é:
1. Bot Buscador de Vagas (mais alinhado a backend Java)
2. Plataforma de simulação estratégica (fullstack, stack mais ampla)
3. Interface de cancelamento de assinaturas (menor peso técnico)

Inverta a ordem entre os itens 1 e 2 se a vaga for claramente fullstack ou enfatizar fortemente React/Node.js/JavaScript no lugar de Java/Spring Boot.

**Experiência profissional:** contém apenas o projeto freelance (CellTech). Sempre presente. Use no máximo 2 bullets — os mais relevantes para a vaga entre os 4 disponíveis. Isso mantém a proporção de menor profundidade em relação aos dois projetos técnicos principais (que podem usar até 4-5 bullets cada, dependendo do espaço).

**Número de bullets por projeto (orientação geral, ajustável para caber em 1 página):**
- Bot Buscador de Vagas: 4 a 5 bullets quando for o projeto de maior relevância para a vaga; 3 bullets quando estiver em segundo lugar
- Plataforma de simulação estratégica: mesma lógica, 4 a 5 quando primeiro, 3 quando segundo
- CellTech (experiência profissional): sempre 2 bullets
- Interface de cancelamento de assinaturas: 1 a 2 bullets, apenas quando houver espaço

**Formação complementar:** reordene os cursos colocando primeiro os mais relevantes para a vaga. Critério objetivo de corte: mantenha apenas cursos com relevância direta para a vaga (tecnologia ou conceito citado na descrição da vaga, ou pré-requisito da stack-alvo). Como referência de quantidade: para vagas Java/backend, normalmente os 3 cursos de Java da Alura são mantidos e os 3 cursos de HTML/CSS/Lógica são omitidos; para vagas frontend, o inverso. Nunca inventar ou alterar o conteúdo dos cursos, apenas selecionar e ordenar.

### Formato de saída
Antes de gerar o JSON, faça internamente esta auto-análise (não inclua essas respostas no output, apenas use-as para corrigir o texto antes de finalizar):

1. Algum bullet foi inventado ou extrapolado além das "realizações disponíveis" da Camada 2?
2. Alguma data foi assumida ou chutada? Use apenas os períodos exatamente como documentados na Camada 2.
3. Alguma frase está em terceira pessoa ou no presente, em vez de primeira pessoa do passado?
4. Algum adjetivo subjetivo ou vazio passou (ver lista na seção Escrita)?
5. Alguma frase ficou genérica o suficiente para que qualquer outro candidato júnior pudesse ter escrito a mesma coisa?
6. O vocabulário da vaga aparece de forma natural, sem forçar termos que não correspondem à realidade do candidato?
7. Algum projeto ultrapassou o limite de bullets definido nas regras de ordenação e priorização?
8. O campo "profile" está dentro do limite de 480 caracteres e passa no teste de especificidade (não genérico)?
9. Existe travessão separando cláusulas em alguma frase? Se sim, reescreva.
10. A formação complementar lista apenas os cursos relevantes para essa vaga específica, e não a lista completa?
11. Alguma skill, ferramenta ou tecnologia foi mencionada fora da lista fechada da Camada 1?
12. Algum item da lista de exclusões da Camada 1 (Gupy, Lovable, CAPEX, palavras de senioridade) apareceu no texto?

Corrija tudo que for necessário antes de prosseguir. Depois, retorne **apenas** o JSON, sem markdown, sem explicações, sem texto antes ou depois.

```json
{
  "profile": "string",
  "skills": {
    "programmingLanguages": "string",
    "framework": "string",
    "databases": "string",
    "tools": "string",
    "others": "string",
    "spokenLanguages": "string"
  },
  "projects": [
    {
      "title": "string",
      "period": "string",
      "bullets": ["string"],
      "stacks": "string"
    }
  ],
  "professionalExperience": [
    {
      "title": "string",
      "period": "string",
      "bullets": ["string"],
      "stacks": "string"
    }
  ],
  "complementaryEducation": ["string"]
}
```

---

## INPUT DINÂMICO

### VAGA
