package com.gabrielpf.wodfeeder.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(schema = "public", name = "warmup")
public class WarmUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "exercises", nullable = false)
	private String exercises;

	public WarmUp(String exercises) { this.exercises = exercises; }

	private WarmUp() {}
}
