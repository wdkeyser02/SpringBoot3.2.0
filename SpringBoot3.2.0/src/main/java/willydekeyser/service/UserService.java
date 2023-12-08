package willydekeyser.service;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import willydekeyser.mapper.UserByUsernameExtractor;
import willydekeyser.mapper.UserExtractor;
import willydekeyser.model.User;

@Service
public class UserService {

	private static final String SQL_FIND_ALL_USERS = """
			SELECT users.username, users.password, users.enabled, authorities.authority 
			FROM users 
			LEFT JOIN authorities ON users.username = authorities.username ;
			""";
	private static final String SQL_FIND_USER_BY_USERNAME = """
			SELECT users.username, users.password, users.enabled, authorities.authority 
			FROM users 
			LEFT JOIN authorities ON users.username = authorities.username 
			WHERE users.username = ?;
			""";
	
	private final JdbcClient jdbcClient;
	
	public UserService(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@PreAuthorize("hasRole('USER')")
	public String getText() {
		return "User:";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return jdbcClient.sql(SQL_FIND_ALL_USERS)
				.query(new UserExtractor());
	}
	
	@PreAuthorize("hasRole('USER')")
	public User findByUsername(String username) {
		return jdbcClient.sql(SQL_FIND_USER_BY_USERNAME)
				.param(username)
				.query(new UserByUsernameExtractor());
	}
}
