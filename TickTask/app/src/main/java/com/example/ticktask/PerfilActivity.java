package com.example.ticktask;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticktask.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPerfilBinding binding;

    private boolean isEditing = false;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText departmentEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        departmentEditText = findViewById(R.id.departmentEditText);
        Button editProfileButton = findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditing = !isEditing;

                // Habilitar o deshabilitar la edición según el estado actual
                emailEditText.setEnabled(isEditing);
                phoneEditText.setEnabled(isEditing);
                departmentEditText.setEnabled(isEditing);


                if (isEditing) {
                    editProfileButton.setText(R.string.guardar);
                } else {
                    // Guardar los cambios realizados en el perfil

                    // Deshabilitar la edición
                    emailEditText.setEnabled(false);
                    phoneEditText.setEnabled(false);
                    departmentEditText.setEnabled(false);
                    editProfileButton.setText("Editar perfil");
                }
            }
        });
   }
}