package com.example.android.disneyquizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int quantity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the submit button is clicked
     * It verifies whether all correct answers are selected and gives 1 point for every correct answer
     * and gives 0 for incorrect answers
     *  At the end, it displays final score and reinitialises the variable score
     */
    public void submitAnswers(View view) {

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct answer is #3: 5
        //------------------------------------------------------------------------------------------
        RadioButton question1_answer3 = (RadioButton) this.findViewById(R.id.question1_answer3);
        boolean answer1 = question1_answer3.isChecked();
        if (answer1) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 2 - Correct answer is #3: Marlon Brando
        //------------------------------------------------------------------------------------------
        RadioButton question2_answer2 = (RadioButton) this.findViewById(R.id.question2_answer2);
        boolean answer2 = question2_answer2.isChecked();
        if (answer2) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 3 - Correct answer is: "sebastian"
        //------------------------------------------------------------------------------------------
        EditText question3_answer = (EditText) this.findViewById(R.id.question3_answer);
        String answer3 = question3_answer.getText().toString().toLowerCase();
        if (answer3.equals("sebastian") || answer3.equals("Sebastian")){
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 4  - Correct answers is: Aurora
        //------------------------------------------------------------------------------------------

        RadioButton question4_answer1 = (RadioButton) this.findViewById(R.id.question2_answer1);
        boolean answer4 = question4_answer1.isChecked();
        if (answer2) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 6  - Correct answers is: Robbie Williams
        //------------------------------------------------------------------------------------------

        RadioButton question6_answer2 = (RadioButton) this.findViewById(R.id.question6_answer2);
        boolean answer6 = question6_answer2.isChecked();
        if (answer6) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 7  - Correct answers is: Robbie Williams
        //------------------------------------------------------------------------------------------

        RadioButton question7_answer3 = (RadioButton) this.findViewById(R.id.question7_answer3);
        boolean answer7 = question7_answer3.isChecked();
        if (answer7) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 8  - Correct answers is: I believe in fairies
        //------------------------------------------------------------------------------------------

        RadioButton question8_answer1 = (RadioButton) this.findViewById(R.id.question8_answer1);
        boolean answer8 = question8_answer1.isChecked();
        if (answer8) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 9  - Correct answers is: a lama
        //------------------------------------------------------------------------------------------

        RadioButton question9_answer1 = (RadioButton) this.findViewById(R.id.question9_answer1);
        boolean answer9 = question9_answer1.isChecked();
        if (answer9) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 10  - Correct answers is: a medallion
        //------------------------------------------------------------------------------------------


        CheckBox question10_answer1 = (CheckBox) this.findViewById(R.id.question10_answer1);
        CheckBox question10_answer2 = (CheckBox) this.findViewById(R.id.question10_answer2);
        CheckBox question10_answer3 = (CheckBox) this.findViewById(R.id.question10_answer3);
        CheckBox question10_answer4 = (CheckBox) this.findViewById(R.id.question10_answer4);
        boolean answer10_answer1 = question10_answer1.isChecked();
        boolean answer10_answer2 = question10_answer2.isChecked();
        boolean answer10_answer3 = question10_answer3.isChecked();
        boolean answer10_answer4 = question10_answer4.isChecked();

        if (answer10_answer1) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 5  - Correct answer is: 3
        //------------------------------------------------------------------------------------------

        if (quantity==3){
            score+=1;
        }

        displayScore(view,score);

        // Set score to zero without pressing reset button
        score = 0;
    }

    //--------------------------------------------------------------------------------------------
    // Final Score
    // This method displays a toast message with the final score when the Submit button is clicked
    //--------------------------------------------------------------------------------------------

    public void displayScore(View view, int score) {
        if (score == 10) {
            Toast.makeText(this, R.string.result_message, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.score_message, score), Toast.LENGTH_LONG).show();
        }
    }

    // This method resets the score and deletes all entered answers
    public int resetScore(View view) {

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.hades);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.bad);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.beauty);
        radioGroup3.clearCheck();

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.aladdin);
        radioGroup4.clearCheck();

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.mulan);
        radioGroup5.clearCheck();

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.tinker);
        radioGroup6.clearCheck();

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.kusko);
        radioGroup7.clearCheck();

        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.anastasia);
        radioGroup8.clearCheck();

        EditText question3_answer = (EditText) this.findViewById(R.id.question3_answer);
        question3_answer.getText().clear();

        CheckBox question10_answer1 = (CheckBox) findViewById(R.id.question10_answer1);
        question10_answer1.setChecked(false);

        CheckBox question10_answer2 = (CheckBox) findViewById(R.id.question10_answer2);
        question10_answer2.setChecked(false);

        CheckBox question10_answer3 = (CheckBox) findViewById(R.id.question10_answer3);
        question10_answer3.setChecked(false);

        CheckBox question10_answer4 = (CheckBox) findViewById(R.id.question10_answer4);
        question10_answer4.setChecked(false);



        score = 0;

        // Setting quantity of movies in question 5
        quantity = 1;
        display(quantity);
        return score ;

    }

    /**
     * This method increases the quantity of Matrix’s movies by 1 each time the button "+" is clicked
     */
    public void increment(View view) {
        if (quantity < 3) {
            quantity += 1;
            display(quantity);
        } else {
            //Show an error message
            Toast.makeText(getApplicationContext(), "3 at max", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method decreases the quantity of Matrix’s movies by 1 each time the button "-" is clicked
     */
    public void decrement(View view) {
        if (quantity == 1) {
            //Show an error message
            Toast.makeText(this, "1 at least", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value in question 5
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}