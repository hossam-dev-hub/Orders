  package com.codwithhossam.progicuser.dto;
  import com.codwithhossam.progicuser.enums.UserType;

import lombok.Data;

  @Data
  public class UserDto {
	  private String name;
      private String email;
      private String password;
      private UserType type;
  }
