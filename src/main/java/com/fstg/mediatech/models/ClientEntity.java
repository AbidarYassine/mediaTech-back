package com.fstg.mediatech.models;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
	
	
	
	@Id()
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@Column(name = "client_telephone")
	private String telephone;
	
	

}
