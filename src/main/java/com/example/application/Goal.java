package com.example.application;

public class Goal {

    private String goal;
    private int achievement;
    private String gap;

    public Goal(String goal, int achievement, String gap) {
        this.goal = goal;
        this.achievement = achievement;
        this.gap = gap;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goal='" + goal + '\'' +
                ", achievement=" + achievement +
                ", gap='" + gap + '\'' +
                '}';
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    public String getGap() {
        return gap;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }
}
