package com.accesodatos.configuration;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accesodatos.entity.Role;
import com.accesodatos.entity.UserEntity;
import com.accesodatos.repository.UserRepository;

@Configuration
public class LoadDatabase {


	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository) {
		return arg -> {
			/** ROLES **/
			Role roleAdmin = Role.builder()
								 .name("ADMIN")
								 .build();
			
			Role roleUser = Role.builder()
					 			.name("USER")
					 			.build();
			
			Role roleInvited = Role.builder()
		 			 			   .name("INVITED")
		 			 			   .build();
			
			Role roleDevelop = Role.builder()
		 			 			   .name("DEVELOPER")
		 			 			   .build();
			
			UserEntity userAlonso = UserEntity.builder()
											.username("Alonso")
											.password("$2a$10$WuJ7nzkzSHzZJZhNwOL2/OSYrX5PJStblUrnWl2QrKI2LyV6L1i/S")
											.isEnable(true)
											.accountNoExpired(true)
											.accountNoLocked(true)
											.credentialNoExpired(true)
											.roles(Set.of(roleAdmin))
											.build();
			
			UserEntity userJose = UserEntity.builder()
											.username("jj")
											.password("$2a$10$WuJ7nzkzSHzZJZhNwOL2/OSYrX5PJStblUrnWl2QrKI2LyV6L1i/S")
											.isEnable(true)
											.accountNoExpired(true)
											.accountNoLocked(true)
											.credentialNoExpired(true)
											.roles(Set.of(roleUser))
											.build();
			
			UserEntity userDaniel = UserEntity.builder()
											  .username("dani")
											  .password("$2a$10$WuJ7nzkzSHzZJZhNwOL2/OSYrX5PJStblUrnWl2QrKI2LyV6L1i/S")
											  .isEnable(true)
											  .accountNoExpired(true)
											  .accountNoLocked(true)
											  .credentialNoExpired(true)
											  .roles(Set.of(roleInvited))
											  .build();

			UserEntity userAndres = UserEntity.builder()
											  .username("andres")
											  .password("$2a$10$WuJ7nzkzSHzZJZhNwOL2/OSYrX5PJStblUrnWl2QrKI2LyV6L1i/S")
											  .isEnable(true)
											  .accountNoExpired(true)
											  .accountNoLocked(true)
											  .credentialNoExpired(true)
											  .roles(Set.of(roleDevelop))
											  .build();
			
			userRepository.saveAll(List.of(userAlonso, userJose, userDaniel, userAndres));
			
		};
	}
	
}
