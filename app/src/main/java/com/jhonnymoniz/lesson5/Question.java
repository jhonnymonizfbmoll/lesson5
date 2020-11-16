package com.jhonnymoniz.lesson5;

public class Question {
    private String question = null;
    private boolean answer = true;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean answer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    private Question() {}

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }
}
