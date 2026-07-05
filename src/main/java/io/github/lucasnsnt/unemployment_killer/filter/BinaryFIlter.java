package io.github.lucasnsnt.unemployment_killer.filter;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;

import io.github.lucasnsnt.unemployment_killer.services.NormalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;


@Service
public class BinaryFIlter implements iFilter {

    @Autowired
    NormalizationService normalizationService;

    @Override
    public boolean binaryFilter(Job job){

        if (Objects.equals(job.getWorkplaceType(), "on-site")
                || Objects.equals(job.getWorkplaceType(), "hybrid")) {
            String[] comparacao = {"sergipe", "se", "aracaju", "aju"};

            String cidade = normalizationService.normalizationMethod(job.getCity());
            String estado = normalizationService.normalizationMethod(job.getState());

            for (String c : comparacao) {
                if ((cidade.equalsIgnoreCase(c) || estado.equalsIgnoreCase(c))) {

                    return true;

                }
            }

            return false;
        }
        return true;
    }

        //  workplaceType — hoje comparado como string crua vinda da Gupy ("on-site"/"hybrid"/"remote").
        //  Funciona porque a Gupy usa um enum fixo e consistente. Quando Indeed for adicionado não há
        //  Garantia do mesmo padrão de valores. Plano: normalizar já no scraper, preenchendo o Job o
        //  com um enum interno (ex: WorkplaceType.REMOTE/HYBRID/ONSITE) em vez de repassar a string
        //  crua da fonte. Isso também elimina a necessidade de qualquer scraper futuro replicar essa comparação aqui.

}
