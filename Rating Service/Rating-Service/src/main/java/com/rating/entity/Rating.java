package com.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rating {
	@Id
	private String id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}

