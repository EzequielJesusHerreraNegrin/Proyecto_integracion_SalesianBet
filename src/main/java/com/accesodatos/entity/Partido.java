package com.accesodatos.entity;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "equipos")
@EqualsAndHashCode(exclude = "equipos")
@Table(name = "partidos")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partido_id")
	private Long id;
	
	@CreationTimestamp
	private Date fecha;
	
	@Column(nullable = false)
	private Boolean ha_comenzado;
	
	@Column(nullable = false)
	private Boolean ha_terminado;
	
	@Column(length = 40, nullable = false)
	private String resultado;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			name = "equipo_partido",
			joinColumns = @JoinColumn(name = "partido_id"),
			inverseJoinColumns = @JoinColumn(name = "equipo_id")
			)
	@JsonBackReference
	private Set<Equipo> equipos = new LinkedHashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "competicion_id", nullable = false)
	@JsonBackReference
	private Competicion competicion;
}
