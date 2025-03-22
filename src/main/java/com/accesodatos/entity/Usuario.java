package com.accesodatos.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "roles")
@EqualsAndHashCode(exclude = "roles")
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String nombre;
	
	@Column(length = 30, nullable = false)
	private String contraseña;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Column(length = 30, nullable = false)
	private String dni;
	
	private int puntos;
	
	
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	@Builder.Default
	private Set<Rol> roles = new HashSet<>();
	
	public void addRole(Rol rol) {
		this.roles.add(rol);
		this.getRoles().add(rol);
	}
	
	
	public void removeRole(Rol rol) {
		this.roles.remove(rol);
		this.getRoles().remove(rol);
	}
}
