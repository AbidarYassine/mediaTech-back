package com.fstg.mediatech.models;

import java.io.Serializable;

/***
 * Entity Client
 * @author yassine
 */
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@Column(name = "client_telephone")
	private String telephone;
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FactureEntity> factures;
	
	
	

}
