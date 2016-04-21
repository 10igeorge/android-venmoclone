package com.izzy.venmoclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewTransactionActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.payButton) Button mPayButton;
    @Bind(R.id.requestButton) Button mRequestButton;
    @Bind(R.id.recipientEditText) EditText mRecipient;
    @Bind(R.id.amountEditText) EditText mAmount;
    @Bind(R.id.reasonEditText) EditText mReason;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);
        ButterKnife.bind(this);

        mPayButton.setOnClickListener(this);
        mRequestButton.setOnClickListener(this);
    }

    @Override
        public void onClick(View v){
        String recipient = mRecipient.getText().toString();
        String amount = mAmount.getText().toString();
        String reason = mReason.getText().toString();
        Intent intent = new Intent(NewTransactionActivity.this, MainActivity.class);
        intent.putExtra("recipient", recipient);
        intent.putExtra("amount", amount);
        intent.putExtra("reason", reason);
        String transaction;
        switch(v.getId()){
            case R.id.payButton:
                transaction = "paid";
                intent.putExtra("transaction", transaction);
                startActivity(intent);
                break;
            case R.id.requestButton:
                transaction = "charged";
                intent.putExtra("transaction", transaction);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
