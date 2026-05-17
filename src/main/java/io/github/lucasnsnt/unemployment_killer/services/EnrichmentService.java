package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.client.OpenRouterClient;
import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrichmentService {

    @Autowired
    OpenRouterClient openRouterClient;

    public String enrich (String texto) {

        String prompt = """
            Você receberá os dados de uma vaga de emprego já formatada.
            Sua tarefa é reescrever essa mensagem mantendo o mesmo formato visual, mas melhorando a qualidade do
             conteúdo.
            
            Regras:
            - Resuma a descrição da vaga sem perder informações importantes como requisitos, responsabilidades e stacks
             tecnológicas
            - Escreva em português brasileiro com acentuação correta
            - Preserve termos técnicos em inglês (ex: Spring Boot, deploy, commit, React, hot fix, etc.)
            - Caso a vaga seja de uma empresa estrangeira ou o conteúdo original esteja em inglês, indique ao final:
             "Vaga de empresa estrangeira"
            - Mantenha o mesmo formato da mensagem recebida: título, descrição resumida, data, localização, tipo de
             trabalho e fonte(s)
            - Não invente informações que não estejam na vaga original
            - Não adicione seções extras além das que já existem na mensagem
            - Não use emojis em nenhuma parte da mensagem
            - A mensagem final deve ter no máximo 4090 caracteres, resumindo o conteúdo o quanto for necessário
             paracaber nesse limite sem cortar informações importantes
            """;

        return openRouterClient.generateContent(texto, prompt);

    }
}
