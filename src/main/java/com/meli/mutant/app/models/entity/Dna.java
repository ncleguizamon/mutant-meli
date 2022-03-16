package com.meli.mutant.app.models.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


import com.sun.istack.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Dna implements Serializable {
	private static final long serialVersionUID = 1L;

    @JsonProperty("dna")
	@NotNull
	@Size(min = 4, max = 15)
	private String[] dna;

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
