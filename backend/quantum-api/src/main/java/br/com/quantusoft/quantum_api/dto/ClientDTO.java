package br.com.quantusoft.quantum_api.dto;


import br.com.quantusoft.quantum_api.entity.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClientDTO {

    private Long id;
    @NotBlank(message = "O campo não pode ser vazio, nulo ou em branco")
    @Size(min = 3,max = 100, message = "O campo Nome deve ter entre 3 a 100 caracteres")
    private String name;
    @NotBlank(message = "O campo não pode ser vazio, nulo ou em branco")
    @Size(min = 11, max = 14, message = "O campo CPF deve ter entre 11 a 14 caracteres")
    private String cpf;
    @NotBlank(message = "O campo não pode ser vazio, nulo ou em branco")
    @Size(min = 14, max = 18, message = "O campo CNPJ deve ter entre 14 a 18 caracteres")
    private String cnpj;
    @NotBlank(message = "O campo não pode ser vazio, nulo ou em branco")
    @Size(min = 9, max = 12, message = "O campo telefone deve ter 9 a 12 caracteres")
    private String cellphone;
    @NotBlank(message = "O campo não pode ser vazio, nulo ou em branco")
    @Email(message = "Email inválido")
    private String email;

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        cnpj = entity.getCnpj();
        cellphone = entity.getCellphone();
        email = entity.getEmail();
    }
}
