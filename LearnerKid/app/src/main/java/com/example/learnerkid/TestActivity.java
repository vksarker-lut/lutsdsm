package com.example.learnerkid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBarTest;
    ImageView imageViewQuestion;
    TextView textViewQuestion;
    Button buttonOption1;
    Button buttonOption2;
    Button buttonOption3;
    Button buttonOption4;

    ArrayList<TestQuestion> testQuestions = getQuestions();
    //        Log.d("Array length of question:", String.valueOf(testQuestions.size()));
    static int questionNumber = 1;
    static int wrongAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        progressBarTest = findViewById(R.id.progressBarTest);
        imageViewQuestion = findViewById(R.id.imageViewQuestion);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonOption4 = findViewById(R.id.buttonOption4);

        // Set click listeners for buttons
        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);

        wrongAnswers = 0;
        questionNumber = 1;
        setQuestionParameters(questionNumber);
    }

    private void setQuestionParameters(int number) {
        TestQuestion question = testQuestions.get(questionNumber -1);

        // Set progress bar according to the number of the question
        progressBarTest.setProgress(question.questionNumber, true);

        // Set image used in the question, if any
        if (question.image == -1) {
            imageViewQuestion.setImageResource(R.drawable.question);
        } else {
            imageViewQuestion.setImageResource(question.image);
        }

        // Set the question according to the question text
        textViewQuestion.setText(question.questionText);

        // Set answer options as labels of the buttons
        buttonOption1.setText(question.option1);
        buttonOption2.setText(question.option2);
        buttonOption3.setText(question.option3);
        buttonOption4.setText(question.option4);
    }

    @Override
    public void onClick(View v) {
        int answerOfUser = -1;

        switch (v.getId()) {
            case R.id.buttonOption1:
                answerOfUser = 1;
                break;
            case R.id.buttonOption2:
                answerOfUser = 2;
                break;
            case R.id.buttonOption3:
                answerOfUser = 3;
                break;
            case R.id.buttonOption4:
                answerOfUser = 4;
                break;
            default:
                break;
        }

        // Check if the right answer was chosen
//        Log.d("User Answer:", String.valueOf(answerOfUser));
//        Log.d("Correct Answer:", String.valueOf(testQuestions.get(questionNumber).answer));
        if (answerOfUser == testQuestions.get(questionNumber -1).answer) {
//            Log.d("Msg:", "Correct!");
        } else {
//            Log.d("Msg:", "Wrong!");
            wrongAnswers++;
        }

        // Increase question index by one to go to the next one
        if (questionNumber < testQuestions.size() - 1)
        {
            questionNumber++;
            setQuestionParameters(questionNumber);
        } else {
            Log.d("Msg:", "Test complete!");
            Log.d("Msg:", "Total wrong answers:"+ wrongAnswers);

            Intent showTestReportActivity = new Intent(getApplicationContext(), TestReportActivity.class);
            showTestReportActivity.putExtra("com.example.learnerkid.WRONG_ANSWERS", wrongAnswers);
            showTestReportActivity.putExtra("com.example.learnerkid.TOTAL_QUESTIONS", testQuestions.size());
            startActivity(showTestReportActivity);
        }
    }
    
    private ArrayList<TestQuestion> getQuestions() {
        ArrayList<TestQuestion> allTheQuestions = new ArrayList<TestQuestion>();

        TestQuestion q1 = new TestQuestion(1,
                "Which of the following is not a vowel?",
                -1, 2, "A", "Y", "O", "I");

        TestQuestion q2 = new TestQuestion(2,
                "How many consonants are there in the English alphabet?",
                -1, 4, "24", "26", "19", "21");

        TestQuestion q3 = new TestQuestion(3,
                "How many letters are there in the English alphabet?",
                -1, 2, "21", "26", "25", "29");

        TestQuestion q4 = new TestQuestion(4,
                "If you add 18 with 7, how much is it in total?",
                -1, 1, "25", "24", "26", "15");

        TestQuestion q5 = new TestQuestion(5,
                "What is 7 multiplied by 4?",
                -1, 3, "11", "21", "28", "35");

        TestQuestion q6 = new TestQuestion(6,
                "What fruit is shown in the image?",
                R.drawable.fruit_banana, 2, "Orange", "Banana", "Mango", "Grapes");

        TestQuestion q7 = new TestQuestion(7,
                "What vegetable is shown in the image?",
                R.drawable.veg_spinach, 1, "Spinach", "Pumpkin", "Tomato", "Potato");

        TestQuestion q8 = new TestQuestion(8,
                "You had 22 pencils. You gave 7 of those to your friend. How much do you have now?",
                -1, 3, "16", "6", "15", "14");

        TestQuestion q9 = new TestQuestion(9,
                "What fruit is shown in the image??",
                R.drawable.fruit_apple, 4, "Banana", "Mango", "Grapes", "Apple");

        TestQuestion q10 = new TestQuestion(10,
                "What vegetable is shown in the image??",
                R.drawable.veg_pumpkin, 3, "Spinach", "Cucumber", "Pumpkin", "Tomato");

        allTheQuestions.add(q1);
        allTheQuestions.add(q2);
        allTheQuestions.add(q3);
        allTheQuestions.add(q4);
        allTheQuestions.add(q5);
        allTheQuestions.add(q6);
        allTheQuestions.add(q7);
        allTheQuestions.add(q8);
        allTheQuestions.add(q9);
        allTheQuestions.add(q10);

        return allTheQuestions;
    }
}