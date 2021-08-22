package com.fstg.mediatech.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/***
 * Class Client Entity
 * @author yassine
 */
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
