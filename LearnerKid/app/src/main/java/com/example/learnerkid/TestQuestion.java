package com.example.learnerkid;

public class TestQuestion {
    // Instance variables
    Integer questionNumber;
    String questionText;
    int image;
    int answer;
    String option1;
    String option2;
    String option3;
    String option4;

    // Class constructor
    public TestQuestion (int questionNumber, String questionText, int image, int answer,
                         String option1, String option2, String option3, String option4) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.image = image;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
