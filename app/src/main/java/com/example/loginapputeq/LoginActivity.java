package com.example.loginapputeq; // <--- ASEGÚRATE DE QUE ESTO COINCIDA CON TU NOMBRE DE PAQUETE

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    // Declaración de campos de entrada y botón
    private TextInputLayout textInputLayoutUsername;
    private TextInputEditText editTextUsername;
    private TextInputLayout textInputLayoutPassword;
    private TextInputEditText editTextPassword;
    private Button btnIngresarLogin;

    // Mapa con credenciales válidas de usuario y contraseña
    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<>();

    // Bloque estático para inicializar el mapa de usuarios y contraseñas
    static {
        VALID_CREDENTIALS.put("Janny Alvarez", "12345");
        VALID_CREDENTIALS.put("Jennifer Delgado", "54321");
        // Puedes agregar más usuarios así:
        // VALID_CREDENTIALS.put("Nombre Apellido", "clave");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular variables con elementos de la interfaz gráfica (layout)
        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        editTextUsername = findViewById(R.id.editTextUsername);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnIngresarLogin = findViewById(R.id.btnIngresarLogin);

        // Configurar el botón para ejecutar la validación al hacer clic
        btnIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin(); // Ejecuta el método de validación
            }
        });
    }

    // Método para validar las credenciales ingresadas
    private void attemptLogin() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Elimina errores anteriores
        textInputLayoutUsername.setError(null);
        textInputLayoutPassword.setError(null);

        boolean isValid = true;

        // Verifica que el campo de usuario no esté vacío
        if (username.isEmpty()) {
            textInputLayoutUsername.setError("Nombre requerido");
            isValid = false;
        }

        // Verifica que el campo de contraseña no esté vacío
        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Clave requerida");
            isValid = false;
        }

        // Si los campos no están vacíos, valida las credenciales
        if (isValid) {
            if (VALID_CREDENTIALS.containsKey(username) && VALID_CREDENTIALS.get(username).equals(password)) {
                // Usuario y contraseña correctos
                Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                // Aquí se puede iniciar otra actividad (ej. pantalla principal)
            } else {
                // Usuario o contraseña incorrectos
                Toast.makeText(LoginActivity.this, "Usuario o clave incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
