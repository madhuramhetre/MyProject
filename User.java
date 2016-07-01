package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 
{
		@Id
		private String username;
		private String password;
		private Integer enabled;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getEnabled() {
			return enabled;
		}
		public void setEnabled(Integer enabled) {
			this.enabled = enabled;
		}
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
		}
		
		
}
