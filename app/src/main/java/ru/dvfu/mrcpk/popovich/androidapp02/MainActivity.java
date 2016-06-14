package ru.dvfu.mrcpk.popovich.androidapp02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_NAME = 1;

    Button buttonEdit;
    String name = "Иванов Иван Иванович";
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        textViewName = (TextView) findViewById(R.id.textName);
        textViewName.setText(name);


        buttonEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEdit:
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("name",name);
//                startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE_NAME);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(data == null) return;
        if(resultCode == RESULT_OK) {
            if(requestCode == REQUEST_CODE_NAME) {
                String nameResult = data.getExtras().getString("name");
                textViewName.setText(nameResult);
            }
        }

    }


}
