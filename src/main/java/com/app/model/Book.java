package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bookstore")

public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "employee_number")
	@Size( max = 20)
	
	private String employee_number;

    // 必須入力、Email形式であること、文字列が30文字まで。
    @NotBlank
    @Email
    @Size( max = 50)
    @Column
    private String employee_mail;

    // 必須入力、文字列が20文字まで。
    @NotBlank
    @Size( max = 30)
    @Column
    private String book_name;
    
    // 必須入力、文字列が50文字まで。
    @NotBlank
    @Size( max = 20)
    @Column
    private String jan_code;
}