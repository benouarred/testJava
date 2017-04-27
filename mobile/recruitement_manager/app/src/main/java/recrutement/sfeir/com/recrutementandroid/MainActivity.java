package recrutement.sfeir.com.recrutementandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText pseudo;
    EditText motDePasse;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Calling super methods
        super.onCreate(savedInstanceState);
        //Setting view
        setContentView(R.layout.activity_main);

        //Logic of our Sfeir app
        pseudo = (EditText) findViewById(R.id.pseudo);
        motDePasse = (EditText) findViewById(R.id.motdepasse);

        login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(pseudo.getText().toString().equals("")) ||((!(pseudo.getText().toString().equals(""))))){


                    Toast.makeText(MainActivity.this, "Pseudo = " + pseudo.getText() + " & Mot de passe = " + motDePasse.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,ListUserActivity.class);
                    intent.putExtra("pseudo",pseudo.getText().toString());
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Pseudo ou mot de passe vide. Veuillez les remplir.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}