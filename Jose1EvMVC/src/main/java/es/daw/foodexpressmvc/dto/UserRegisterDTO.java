package es.daw.foodexpressmvc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    @Size(min = 4, max = 50, message = "El nombre de usuario debe tener al menos 4 caracteres")
    private String username;

    @Size(max = 100, message = "El nombre completo no puede superar los 100 caracteres")
    private String fullName;

    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    private String email;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String password;

    @NotBlank(message = "La confirmación de contraseña no puede estar en blanco")
    private String confirmPassword;
}

