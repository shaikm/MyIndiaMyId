package com.myindia.mygo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final int SELECT_FILE = 101 ;
    private Spinner genderSpinner, sBloodGroup;
    private String[] gender = {"Choose Gender", "Male", "Female"};
    private String[] salutation = {"Salutation", "Mr.", "Miss", "Mrs."};
    private String[] bloodGroup = {"Choose Blood Group", "A+ve", "A-ve", "B+ve", "B-ve", "AB+ve", "AB-ve", "O+ve", "O-ve"};
    private String[] country = {"Select Country", "Australia", "India", "New Zealand", "USA", "UAE", "Mauritius"};
    private String[] religion = {"Select Religion", "Christian", "Islam", "Hinduism", "Buddhism", "Sikhism", "Judaism", "Jainism", "Nonreligious"};

    private Spinner sSalutation,sReligion;
    private Button btnDate;
    private Spinner sCountry, sState, sDistrict;
    private EditText txtDate;
    private String userChoosenTask;
    private final int REQUEST_CAMERA = 100;
    private ImageView ivImage;
    private Button btnPhoto;
    private Button btnSubmit;
    private EditText etFirstName, etLastName, etFatherName, etEmail, etMobile, etPassword, etConfirmPassword, etCity, etReferenceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        sBloodGroup = (Spinner) findViewById(R.id.sBloodGroup);
        sSalutation = (Spinner) findViewById(R.id.spSalutation);
        sReligion = (Spinner) findViewById(R.id.religonSpinner);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etFatherName = (EditText) findViewById(R.id.etFatherName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMobile = (EditText) findViewById(R.id.etPhoneNumber);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etCPassword);
        etCity = (EditText) findViewById(R.id.etCity);
        etReferenceId = (EditText) findViewById(R.id.etReferenceId);

        sCountry = (Spinner) findViewById(R.id.sCountry);
        sState = (Spinner) findViewById(R.id.sState);
        sDistrict = (Spinner) findViewById(R.id.sDistrict);

        btnDate = (Button) findViewById(R.id.btn_date);
        txtDate = (EditText) findViewById(R.id.etDOB);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        btnPhoto = (Button) findViewById(R.id.btnSelectPhoto);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });
        initSpinners();
    }

    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txtDate.setText(String.format(Locale.US, "%d/%d/%d", dayOfMonth, monthOfYear + 1, year));
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void initSpinners() {
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, gender);
        ArrayAdapter<String> bloodGroupAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, bloodGroup);
        ArrayAdapter<String> salutationAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, salutation);
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, country);
        ArrayAdapter<String> religionAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, religion);

        genderSpinner.setAdapter(genderAdapter);
        sBloodGroup.setAdapter(bloodGroupAdapter);
        sSalutation.setAdapter(salutationAdapter);
        sCountry.setAdapter(countryAdapter);
        sReligion.setAdapter(religionAdapter);

        sCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    loadStateSpinner((String) adapterView.getSelectedItem());
                    sDistrict.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadStateSpinner(String selectedItem) {
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, CountryHelper.getCityByName(selectedItem));

        sState.setAdapter(stateAdapter);
        sState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    loadCitySpinner((String) adapterView.getSelectedItem());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadCitySpinner(String selectedItem) {
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, CountryHelper.getDistrictByName(selectedItem));
        sDistrict.setAdapter(districtAdapter);
    }


    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Util.checkPermission(MainActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";
                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Util.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ivImage.setImageBitmap(bm);
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ivImage.setImageBitmap(thumbnail);
    }

    private void postData() {
        if (checkValidations())
            uploadDataToServer();

    }

    private void uploadDataToServer() {
    }

    private boolean checkValidations() {
        if (sSalutation.getSelectedItem().toString().equalsIgnoreCase("Salutation")) {
            ((TextView)sSalutation.getSelectedView()).setError("Please  select salutation");
            return false;
        }
        if (TextUtils.isEmpty(etFirstName.getText())) {
            etFirstName.setError("Fistname should not be empty");
            return false;
        }
        if (TextUtils.isEmpty(etLastName.getText())) {
            etLastName.setError("Last Name should not be empty");
            return false;
        }
        if (TextUtils.isEmpty(etFatherName.getText())) {
            etFatherName.setError("Father Name should not be empty");
            return false;
        }
        if (TextUtils.isEmpty(etEmail.getText())) {
            etEmail.setError("Email should not be empty");
            return false;
        }
        if (!isValidEmail(etEmail.getText())) {
            etEmail.setError("Please enter valid email");
            return false;
        }
        if (TextUtils.isEmpty(txtDate.getText())) {
            txtDate.setError("Date should not be empty");
            return false;
        }
        if (TextUtils.isEmpty(etMobile.getText())) {
            etMobile.setError("Mobile Number should not be empty");
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Password should not be empty");
            return false;
        }
        if (TextUtils.isEmpty(etConfirmPassword.getText())) {
            etConfirmPassword.setError("Confirm Password should not be empty");
            return false;
        }
        if (!etConfirmPassword.getText().toString().equalsIgnoreCase(etPassword.getText().toString())) {
            etConfirmPassword.setError("Confirm Password is not matched with Password");
            return false;
        }
        if (genderSpinner.getSelectedItem().toString().equalsIgnoreCase("Choose Gender")) {
            ((TextView)genderSpinner.getSelectedView()).setError("Please select Gender");
            return false;
        }

        if (sBloodGroup.getSelectedItem().toString().equalsIgnoreCase("Choose Blood Group")) {
            ((TextView)sBloodGroup.getSelectedView()).setError("Please select Blood Group");
            return false;
        }

        if (sCountry.getSelectedItem().toString().equalsIgnoreCase("Select Country")) {
            ((TextView)sCountry.getSelectedView()).setError("Please select Country");
            return false;
        }

        if (sState.getSelectedItem().toString().equalsIgnoreCase("Select State")) {
            ((TextView)sState.getSelectedView()).setError("Please select State");
            return false;
        }

        if (sDistrict.getSelectedItem().toString().equalsIgnoreCase("Select District")) {
            ((TextView)sDistrict.getSelectedView()).setError("Please select District");
            return false;
        }

        if (TextUtils.isEmpty(etCity.getText())) {
            etCity.setError("City should not be empty");
            return false;
        }
        if (sReligion.getSelectedItem().toString().equalsIgnoreCase("Select Religion")) {
            ((TextView)sReligion.getSelectedView()).setError("Please select Religion");
            return false;
        }
        return true;
    }
    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
