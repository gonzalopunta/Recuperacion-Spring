package com.example.JWT;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter @Setter
public class JwtRequest implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;

	private String username;

	private String password;
	
}
