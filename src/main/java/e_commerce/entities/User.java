package e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String name;
	
	@NotNull(message = "CPF é obrigatório")
	@Column(unique = true)
	private String cpf;
	
	@NotNull(message = "Email é obrigatório")
	@Column(unique = true)
	private String email;
	
	@NotNull(message = "Senha é obrigatória")
	private String password;
	
	private String phone;
	
}
