package ru.dvfu.mrcpk.popovich.androidapp02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = "Gorynych Log";

    final int REQUEST_CODE_NAME = 1;

    Button buttonEdit;
    String name = "Иванов Иван Иванович" ;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG,"Создание кнопок");

        // Присвоение
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        textViewName = (TextView) findViewById(R.id.textName);
        textViewName.setText(name);


        buttonEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEdit:
                //Создание объекта intent, в котором указывается, какое активити далее вызывать
                Intent intent = new Intent(this, EditActivity.class);
                //Установка передаваемых значений в формате Ключ-Значение (MAP)
                intent.putExtra("name",name);
//                startActivity(intent);
                //Вызов метода для запуска поиска и запуска активити и передача заданных значений с идентификатором запроса
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
        //Проверка условия - прошел вызов или нет
        if(resultCode == RESULT_OK) {
            //Идентификатор запроса (смотреть выше в методе onClick())
            if(requestCode == REQUEST_CODE_NAME) {
                //Извлечение результата обработки из возвращаемых данных (по идентификатору)
                String nameResult = data.getExtras().getString("name");
                textViewName.setText(nameResult);
            }
        }

    }
}
