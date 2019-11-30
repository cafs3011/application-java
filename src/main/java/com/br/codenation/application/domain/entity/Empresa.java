package com.br.codenation.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "vagas")
    private int vagas;

	@Column(name = "site", nullable = false, length = 255)
    private String site;

	@JsonIgnore
    @OneToMany(mappedBy="id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

	@Column(name = "nome", nullable = false, length = 255)
    private String nome;

	@Column(name = "documento", nullable = false, length = 255)
    private String documento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
