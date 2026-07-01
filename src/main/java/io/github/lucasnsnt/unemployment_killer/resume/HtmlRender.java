package io.github.lucasnsnt.unemployment_killer.resume;

import io.github.lucasnsnt.unemployment_killer.resume.model.ResumeResponse;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Service
public class HtmlRender {


    private final TemplateEngine templateEngine;

    public HtmlRender() {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        this.templateEngine = engine;
    }

    public String render(ResumeResponse resumeResponse) {

        Context context = new Context();
        context.setVariable("resume", resumeResponse);
        return  templateEngine.process("curriculo", context);
    }

}
