package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /***
     * Checks if the answer entered matches the correct answer
     * @return true or false
     */
    public boolean Question1() {
        EditText hearts = findViewById(R.id.howManyHearts);
        String theGuess = hearts.getText().toString();
        boolean theAnswer = theGuess.equals("3");

        return (theAnswer);
    }

    /***
     * Checks if the right checkboxes for this question are correct
     * @return true or false
     */
    public boolean Question2() {
        CheckBox bear = findViewById(R.id.mammal1);
        CheckBox whale = findViewById(R.id.mammal2);
        CheckBox platypus = findViewById(R.id.mammal3);
        CheckBox snake = findViewById(R.id.not_mammal1);
        CheckBox eagle = findViewById(R.id.not_mammal2);
        boolean bearIsRight = bear.isChecked();
        boolean whaleIsRight = whale.isChecked();
        boolean platypusIsRight = platypus.isChecked();
        boolean snakeIsWrong = snake.isChecked();
        boolean eagleIsWrong = eagle.isChecked();

        boolean rightAnswer=  bearIsRight && whaleIsRight && platypusIsRight && !eagleIsWrong && !snakeIsWrong;

        return rightAnswer;
    }

    /***
     * Checks if the right RadioButton is selected for this answer
     *
     * @return true or false
     */
    public boolean Question3() {
        RadioButton onTheBeach = findViewById(R.id.right_answer1);
       boolean rightAnswer = onTheBeach.isChecked();

       return rightAnswer;
    }

    /***
     * Checks to see if the correct answer is selected for this question
     * @return true or false
     */
    public boolean Question4(){
        RadioButton howManyLegs = findViewById(R.id.right_answer6);
        boolean tenIsRight = howManyLegs.isChecked();

        return tenIsRight;
    }

    /***
     * Checks to see if the right RadioButton is pressed for this question
     * @return true or false
     */
    public boolean Question5() {
        RadioButton babyGoat = findViewById(R.id.right_answer5);
        boolean kidIsRight = babyGoat.isChecked();

        return kidIsRight;
    }

    /***
     * Checks the text answered to the correct answer
     * @return true or false
     */
    public boolean Question6() {
        EditText fastest = findViewById(R.id.fastestAnimal);
        String theGuess = fastest.getText().toString().toLowerCase().trim();
        boolean theAnswer = theGuess.equals("cheetah");

        return theAnswer;
    }

    /***
     * caluclates the number of correct answers scored
     * @return the number of questions answered correctly
     */
    public int answerCount() {
       int wrongAnswers = 0;
        int rightAnswers = 0;
        int questions = 6;
        if (Question1()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }
        if (Question2()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }
        if (Question3()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }
        if (Question4()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }
        if (Question5()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }
        if (Question6()) {
            rightAnswers +=1;
        } else {
            wrongAnswers +=1;
        }

        return rightAnswers | questions - wrongAnswers;
    }


    /***
     *This method checks how many right answers were entered in quiz.
     *Displays the score of the game when the submit button is pressed
     *
     *
     * @param view displays results of quiz
     */
    public void submitAnswer(View view) {
        if (answerCount() == 6) {
            Toast.makeText(this, getString(R.string.toastAllCorrect), Toast.LENGTH_LONG).show();
        } else {
            String toastMessage = "You got " + answerCount() + " out of 6 questions correct. Don't give up!";
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
        }
    }

}
