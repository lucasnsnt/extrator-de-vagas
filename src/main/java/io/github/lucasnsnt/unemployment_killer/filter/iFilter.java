package io.github.lucasnsnt.unemployment_killer.filter;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface iFilter {

    boolean binaryFilter(Job job);
}
