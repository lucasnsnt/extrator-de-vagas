package io.github.lucasnsnt.unemployment_killer.services;

import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class NormalizationService {

    public String normalizationMethod(String text) {

        if (text == null) {
            return "";
        }

        text = text.replace("\u00A0", "").toLowerCase().trim();
        text = text.replace("-" , " ").replace("_" , " ");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[^a-z0-9 ]+", "");
        text = text.replaceAll("\\s+" ," ");

        return text;
    }
}
