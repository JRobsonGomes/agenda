package entidades;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
public class Contato {
	private Long id;
	@NonNull private String nome;
	private String telefone;
	private String email;	
}
