package ru.myitschool.lab23;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private ActivityMainBinding binding;

    public Button saveButton;
    public TextInputEditText etTitle;
    public TextInputEditText etTime;
    public TextInputEditText etNote;
    public AlertDialog.Builder builder;
    public String date;


    TimePickerDialog picker;
//    TimePicker picker;
//    Button btnGet;
//    TextView tvw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set-24hr's-picker
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relLayout);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        View layout = findViewById(R.id.constraint_layout);
        Button saveButton = (Button) findViewById(R.id.save_button);
        final TextInputEditText etTitle = (TextInputEditText) findViewById(R.id.event_title_user_input_et);
        TextInputEditText etTime = (TextInputEditText) findViewById(R.id.event_time_user_input_et);
        TextInputEditText etNote = (TextInputEditText) findViewById(R.id.event_notes_user_input_et);

        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat parser = new SimpleDateFormat("dd.MM.yyyy",   Locale.US);

        //Clear_input_metod_for_clean_start_TimePickerDialog
        etTime.setInputType(InputType.TYPE_NULL);
//        TimePicker picker =(TimePicker)findViewById(R.id.timePicker1);
//        picker.setIs24HourView(true);
        final Snackbar[] snackbar = {Snackbar
                .make(constraintLayout, "www.journaldev.com", Snackbar.LENGTH_LONG)};
        snackbar[0].show();

        builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file




        binding.content.saveButton.setOnClickListener(v -> {
            String etTexttitle = etTitle.getText().toString();
            Log.d(TAG, "viewId: " + etTexttitle);
            if (!etTexttitle.equals ("")) {
                snackbar[0] = Snackbar
                        .make(constraintLayout, "2222.journaldev.com", Snackbar.LENGTH_LONG);
                snackbar[0].show();
                alertDiaShow();
            } else {
                snackbar[0] = Snackbar.make(constraintLayout, R.string.no_title, Snackbar.LENGTH_LONG);
                snackbar[0].show();

            }
        });

        binding.content.eventTimeUserInputEt.setOnClickListener(v ->
        {
//            picker.setVisibility(View.VISIBLE);
            final Calendar cldr = Calendar.getInstance();
//            long date = cldr.getTimeInMillis();

            int hours = cldr.get(Calendar.HOUR_OF_DAY);
            int minutes = cldr.get(Calendar.MINUTE);
            picker = new TimePickerDialog(MainActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                            etTime.setText(sHour + ":" + sMinute);
                        }
                    }, hours, minutes, true);
            picker.show();
            // time picker dialog
//            int hour, minute;
//            String am_pm;
//            if (Build.VERSION.SDK_INT >= 23 ){
//                hour = picker.getHour();
//                minute = picker.getMinute();
//            }
//            else{
//                hour = picker.getCurrentHour();
//                minute = picker.getCurrentMinute();
//            }
//            if(hour > 12) {
//                am_pm = "PM";
//                hour = hour - 12;
//            }
//            else
//            {
//                am_pm="AM";
//            }
//            etTime.setText("Selected Date: "+ hour +":"+ minute+" "+am_pm);
        });

    }

    public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


    private void alertDiaShow(){
        TextInputEditText etTitle = (TextInputEditText) findViewById(R.id.event_title_user_input_et);
        TextInputEditText etTime = (TextInputEditText) findViewById(R.id.event_time_user_input_et);
        TextInputEditText etNote = (TextInputEditText) findViewById(R.id.event_notes_user_input_et);
        String date = getCurrentLocalDateTimeStamp();
        Log.d(TAG,"____DATE= "+date);
        builder
                .setMessage(getString(R.string.alertEvent_title)+etTitle.getText()+"\n"+getString(R.string.alertEvent_date)+date+"\n"+getString(R.string.alertEvent_time)+etTime.getText()+"\n"+getString(R.string.alertEvent_notes)+etNote.getText()+"\n")
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