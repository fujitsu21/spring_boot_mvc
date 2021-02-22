package com.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	
	 @NotBlank
	 @Size( max = 20)
	 private String employee_number;

    // 必須入力、Email形式であること、文字列が30文字まで。
    @NotBlank
    @Email
    @Size( max = 30)
    private String employee_mail;

    // 必須入力、文字列が20文字まで。
    @NotBlank
    @Size( max = 20)
    private String book_name;
    
    // 必須入力、文字列が50文字まで。
    @NotBlank
    @Size( max = 20)
    private String jan_code;
}