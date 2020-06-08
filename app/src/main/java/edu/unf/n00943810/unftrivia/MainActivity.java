package edu.unf.n00943810.unftrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView mQuestionTV;
    private Button zeroButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;

    private int firstNumber;
    private int secondNumber;
    private double totalResult = 0.0;

    private int mCurrentIndex = 0;

    private boolean [] mAnswerBank = new boolean [] {true, false, true};

    private static final String KEY_INDEX =  "index";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTV = (TextView)findViewById(R.id.textView);
        mQuestionTV.setText("0");

        //Overriding onSaveInstanceState
        mQuestionTV = (TextView) findViewById(R.id.textView);

        //Buttons pressed and action Done
        //Zero Button pressed
        zeroButton = (Button) findViewById(R.id.Zero);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(mQuestionTV == "0")
                {

                }
                mQuestionTV.setText("0");
                firstNumber += 0;
            }
        });
        //Zero Button pressed
        oneButton = (Button) findViewById(R.id.One);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mQuestionTV.setText("");
                firstNumber += 0;
            }
        });



        //Hint Button
        mHintButton = (Button) findViewById(R.id.Two);
        mHintButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, HintActivity.class);
                boolean answerIsTrue = mAnswerBank[mCurrentIndex];
                i.putExtra(HintActivity.EXTRA_ANSWER, answerIsTrue);
                startActivityForResult(i, 0);
            }
        });
        //Next Button pressed
        mNextButton = (Button) findViewById(R.id.Three);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mCurrentIndex++;
                if(mCurrentIndex > 2)
                {
                    mCurrentIndex = 0;
                }
                mAnswerTV.setText(R.string.answer_text);
                mQuestionTV.setText(mQuestionBank[mCurrentIndex]);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(data == null)
            return;
        mIsHintShown = data.getBooleanExtra(HintActivity.EXTRA_ANSWER_SHOWN, false);

    }


}
