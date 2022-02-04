package com.coomeva.credisolidario.domain;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametrosBase {
	@Id
	@GeneratedValue
	@Column(updatable=false, nullable=false)
	Long id;
	
	@Column
	String estadosPermitidos;
	
	@Column
	Integer minAntiguedad;
	
	@Column
	Long valorMinimoCredisolidario;
	
	@Column
	Long valorMaximoCredisolidario;
	
	@Column
	Long valorSMMV;
	
	@Column
	String correoLog;
	
	@Column
	Long intervaloValorMonto;
	
	@Column
	Integer intervaloPlazo;
	
	@Column
	String linkTyC;
	
	@Column
	String mensajeInformativoTasa;
	
	/*
	 * @Column String productosValidar;
	 * 
	 * @Column String fechaPerseverancia;
	 */
	
	@Column
	boolean activo;
	
	@Column(updatable = false)
	String usuarioCreacion;
	
	@Column
	String usuarioModificacion;
	
	@CreationTimestamp
	@Column(updatable = false)
	Timestamp fechaCreacion;
	
	@UpdateTimestamp
	@Column
	Timestamp fechaModificacion;
}