package io.github.lucasnsnt.unemployment_killer.utils;

import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ResourceReader {


    private ResourceReader() {
        throw new UnsupportedOperationException("Classe utilitária não instanciada");
    }


    public static String resourceReader (Resource  resource) throws Exception {


        try (InputStreamReader reader = new InputStreamReader(
            resource.getInputStream(),
                StandardCharsets.UTF_8)) {

            return FileCopyUtils.copyToString(reader);

        } catch (IOException e) {
            throw new Exception("Error reading file", e); // thorw simplificada
        }
    }

}
