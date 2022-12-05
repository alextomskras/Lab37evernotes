package ru.myitschool.lab23;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private ActivityMainBinding binding;

    public Button saveButton;
    public TextInputEditText etTitle;
    public TextInputEditText etTime;
    public TextInputEditText etNote;
    public AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        View layout = findViewById(R.id.constraint_layout);
        Button saveButton = (Button) findViewById(R.id.save_button);
        final TextInputEditText etTitle = (TextInputEditText) findViewById(R.id.event_title_user_input_et);
        TextInputEditText etTime = (TextInputEditText) findViewById(R.id.event_time_user_input_et);
        TextInputEditText etNote = (TextInputEditText) findViewById(R.id.event_notes_user_input_et);

        final Snackbar[] snackbar = {Snackbar
                .make(constraintLayout, "www.journaldev.com", Snackbar.LENGTH_LONG)};
        snackbar[0].show();

        builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder
                .setMessage(getString(R.string.alertEvent_title)+"\n"+getString(R.string.alertEvent_date)+"\n"+getString(R.string.alertEvent_time)+"\n"+getString(R.string.alertEvent_notes))
//                .setMessage(R.string.alertEvent_date)
//                .setMessage(R.string.alertEvent_time)
//                .setMessage(R.string.alertEvent_notes)
                .setTitle(R.string.alertTitle)
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                });

//        Creating dialog box
//        AlertDialog alert = builder.create();
//        //Setting the title manually
////        alert.setTitle("AlertDialogExample");
//        alert.show();
        builder.show();
//    }



        binding.content.saveButton.setOnClickListener(v -> {
            String etTexttitle = etTitle.getText().toString();
            Log.d(TAG, "viewId: " + etTexttitle);
            if (etTexttitle.equals ("sss")) {
                snackbar[0] = Snackbar
                        .make(constraintLayout, "2222.journaldev.com", Snackbar.LENGTH_LONG);
                snackbar[0].show();
            } else {
                snackbar[0] = Snackbar.make(constraintLayout, R.string.no_title, Snackbar.LENGTH_LONG);
                snackbar[0].show();
            }
        });

    }
}

/*
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
*/