package io.github.lucasnsnt.unemployment_killer.resume.model;

import java.util.List;

public class Projects {
    String title;
    String period;
    List<String> bullets;
    String stacks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<String> getBullets() {
        return bullets;
    }

    public void setBullets(List<String> bullets) {
        this.bullets = bullets;
    }

    public String getStacks() {
        return stacks;
    }

    public void setStacks(String stacks) {
        this.stacks = stacks;
    }
}
