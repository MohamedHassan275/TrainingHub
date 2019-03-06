package com.example.mohamedhassan.traininghub.Register;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedhassan.traininghub.Home.HomeMain;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.Home.Home_fragment;
import com.example.mohamedhassan.traininghub.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {


    EditText Password;
            //Confirm_Password;
    //ConfirmPasswordInput
    private View mProgressView;
    private TextInputLayout NameInput,EmailInput,PasswordInput,phoneInput,cityInput;
    private TextView governmentText,ganderText,regText;
    private RadioGroup radioGroup;
    private RadioButton radioButton,maleRadio;
    private String radioSelected;
    private Button regButton;
    private Spinner spinner;
    CheckBox checkBoxShowPassword;
    ArrayAdapter<CharSequence> arrayAdapter;
    String spinnerSelected;
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterActivity.this.setTitle(R.string.Register);



        NameInput = findViewById(R.id.signup_input_layout_name);
        EmailInput = findViewById(R.id.signup_input_layout_email);
        PasswordInput = findViewById(R.id.signup_input_layout_password);
      //  ConfirmPasswordInput = findViewById(R.id.signup_input_layout_confirm_password);
        phoneInput = findViewById(R.id.signup_input_layout_mobile);
        cityInput = findViewById(R.id.signup_input_layout_city);
        spinner =findViewById(R.id.spinnerGovernment);
        checkBoxShowPassword = findViewById(R.id.ChShowPassword);
        regButton = findViewById(R.id.btn_register);
        regText = findViewById(R.id.btn_intent_login);
        mProgressView = findViewById(R.id.m_progress);


        Password = findViewById(R.id.Ed_reg_password);
     //   Confirm_Password = findViewById(R.id.Ed_reg_confirmpassword);




        registerPresenter = new RegisterPresenter(this,this);

        checkBoxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                  //  Confirm_Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                  //  Confirm_Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.government_arrray , android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSelected = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        radioGroup=findViewById(R.id.gender_radio_group);
        maleRadio=findViewById(R.id.male_radio_btn);
        maleRadio.setChecked(true);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selectedId);
                radioSelected=radioButton.getText().toString();
                attemptRegister();
            }
        });


        regText.setOnClickListener(view -> IntentLogin());


    }




    @Override
    public void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(boolean show) {

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void IntentLogin() {


        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMain() {

        Intent intent = new Intent(RegisterActivity.this, Home_fragment.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean isNameValid(String Name) {
        return Name.length() > 3;
    }

    @Override
    public boolean isEmailValid(String Email) {
        return Email.contains("@");
    }

    @Override
    public boolean isPhoneValid(String Phone) {
        return Phone.length() > 10;
    }

    @Override
    public boolean isGenderValid(String Gender) {
        return false;
    }

    @Override
    public boolean isGovernmentValid(String gov) {
        return false;
    }

    @Override
    public boolean isPasswordValid(String Password) {
        return Password.length() > 5;
    }

    @Override
    public void attemptRegister() {

        NameInput.setError(null);
        EmailInput.setError(null);
        phoneInput.setError(null);
        cityInput.setError(null);
        PasswordInput.setError(null);
     //   ConfirmPasswordInput.setError(null);


        String nameStr=NameInput.getEditText().getText().toString();
        String emailStr=EmailInput.getEditText().getText().toString();
        String passStr=PasswordInput.getEditText().getText().toString();
        String phoneStr=phoneInput.getEditText().getText().toString();
        String cityStr=cityInput.getEditText().getText().toString();

        boolean cancel = false;
        View focusView = null;

        if(TextUtils.isEmpty(nameStr)){
            NameInput.setError(getString(R.string.error_field_required));
            focusView = NameInput;
            cancel = true;
        }else if(!TextUtils.isEmpty(nameStr) && !isNameValid(nameStr)){
            NameInput.setError(getString(R.string.error_field_required));
            focusView = NameInput;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            EmailInput.setError(getString(R.string.error_field_required));
            focusView = EmailInput;
            cancel = true;
        } else if (!isEmailValid(emailStr)) {
            EmailInput.setError(getString(R.string.error_invalid_email));
            focusView = EmailInput;
            cancel = true;
        }
        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(passStr)) {
            PasswordInput.setError(getString(R.string.error_field_required));
            focusView = PasswordInput;
            cancel = true;
        } else if (!TextUtils.isEmpty(passStr) && !isPasswordValid(passStr)) {
            PasswordInput.setError(getString(R.string.error_invalid_password));
            focusView = PasswordInput;
            cancel = true;
        }
        // Check for a valid phone, if the user entered one.
        if (TextUtils.isEmpty(phoneStr)) {
            phoneInput.setError(getString(R.string.error_field_required));
            focusView = phoneInput;
            cancel = true;
        } else if (!TextUtils.isEmpty(phoneStr) && !isPhoneValid(phoneStr)) {
            phoneInput.setError(getString(R.string.error_field_required));
            focusView = phoneInput;
            cancel = true;
        }
        // Check for a valid City, if the user entered one.
        if (TextUtils.isEmpty(cityStr)) {
            cityInput.setError(getString(R.string.error_field_required));
            focusView = cityInput;
            cancel = true;
        } /*else if (!TextUtils.isEmpty(cityStr) && !isGenderValid(cityStr)) {
            cityInput.setError(getString(R.string.error_field_required));
            focusView = cityInput;
            cancel = true;
        }*/
        // Check for a valid government address.
        if (TextUtils.isEmpty(spinnerSelected)) {
            governmentText.setError(getString(R.string.error_field_required));
            focusView = governmentText;
            cancel = true;
        } /*else if (!isGovernmentValid(spinnerSelected)) {
            governmentText.setError(getString(R.string.error_invalid_email));
            focusView = governmentText;
            cancel = true;
        }*/
        // Check for a valid gander address.
        if (TextUtils.isEmpty(radioSelected)) {
            ganderText.setError(getString(R.string.error_field_required));
            focusView = ganderText;
            cancel = true;
        }

        if(cancel){
            focusView.requestFocus();
        }else {
            showProgress(true);


            registerPresenter.register(emailStr,nameStr,passStr,phoneStr,radioSelected,spinnerSelected,cityStr);
            Toast.makeText(this,"Register done!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this,HomeMain.class);
            startActivity(intent);
        }


    }
}
