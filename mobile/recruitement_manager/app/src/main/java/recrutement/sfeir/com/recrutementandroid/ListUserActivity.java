package recrutement.sfeir.com.recrutementandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends Activity {

    ListView listView;
    List<String> personList;
    Button btnAdd;
    EditText field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);


        Intent intent = getIntent();
        String pseudo = "";
        if (intent != null) {
            pseudo = intent.getStringExtra("pseudo");
        }

        btnAdd = (Button) findViewById(R.id.button_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (field != null) {
                    if (field.getText() != null) {
                        String personNameToAdd = field.getText().toString();
                        personList.add(personNameToAdd);
                        if (listView != null && listView.getAdapter() != null) {
                            ((ArrayAdapter) listView.getAdapter()).notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        field = (EditText) findViewById(R.id.field_add);
        personList = new ArrayList<String>();
        personList.add("Siegfried");
        personList.add("Louis");
        personList.add("Wajdi");


        Toast.makeText(this, "Pseudo passé à la ListUserActivity :" + pseudo, Toast.LENGTH_SHORT).show();

        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
