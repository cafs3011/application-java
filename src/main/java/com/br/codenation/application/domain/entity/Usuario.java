package com.br.codenation.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "documento", nullable = false, length = 255)
    private String documento;

    @Column(name = "idade")
    private int idade;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @ManyToOne
	@JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "salario")
    private BigDecimal salario;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public Usuario(Usuario user) {
        super();
        this.nome = user.getNome();
        this.documento = user.getDocumento();
        this.idade = user.getIdade();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.senha = user.getSenha();

    }
}
