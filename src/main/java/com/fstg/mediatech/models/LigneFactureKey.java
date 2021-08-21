package com.fstg.mediatech.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LigneFactureKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4722352116317893282L;

	
	@Column(name="facture_id")
	private Integer factureId;
	
	@Column(name="produit_id")
	private Integer produitId;
}
