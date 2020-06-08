package edu.unf.n00943810.unftrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {


    public static final String EXTRA_ANSWER = "edu.unf.n00943810.extra_answer";
    public static final String EXTRA_ANSWER_SHOWN = "edu.unf.n00943810.unftrivia.extra_answer_shown";
    private boolean mAnswerIsTrue;
    private Button mShowButton;
    private TextView mHintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        mHintView = (TextView)findViewById(R.id.hint_textView);
        mHintView.setText(R.string.hint_text);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER, false);



        setAnswerShownResult(false);

        //Show Button pressed
        mShowButton = (Button) findViewById(R.id.showAnswer_button);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mHintView.setText("The Answer is " + mAnswerIsTrue);
                setAnswerShownResult(true);

            }
        });

    }

    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
