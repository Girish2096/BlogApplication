package com.girish.crudoperation.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Product_id")
	private Integer pid;
	
	@Column(name="Product_Name")
	@NotNull
	@Size(min=3,max=15)
	private String pname;
	
	@Column(name="Product_Price")
	@NotNull
	private double pprice;
	
	@Column(name="Product_Category")
	@NotNull
	private String pcategory;
	
	@Column(name="Create_Date",insertable = true)
    @CreationTimestamp
	private LocalDate createdate;
	
	@Column(name="Update_Date",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedate;
	

}
