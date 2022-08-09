package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.utils.DBUtils;

public class UserRepoImpl implements UserRepo {
	
	private Set<User> users = new HashSet<>();
	
	private UserRepoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    private static UserRepo userRepo;
    
    public static UserRepo getInstance() {
        // userRepo object
        
        if(userRepo == null) {
            userRepo = new UserRepoImpl();
            
        }
        
        return userRepo;
    }

    private DBUtils dbUtils = DBUtils.getInstance();
    
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
//		boolean result = users.add(user);
//		if(result) {
//			return user;
//		}else
//		return null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		String insertStatement = "insert into user_table "
				+ "(userid, firstname, lastname, email, doj, dob, active) "
				+ "values(?,?,?,?,?,?,?)"; 
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setDate(5, Date.valueOf(user.getDoj()));
			preparedStatement.setDate(6, Date.valueOf(user.getDob()));
			preparedStatement.setBoolean(7, user.isActive());
			
			int result = preparedStatement.executeUpdate();
			if (result>0) {
				return user;
			}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public Optional<User> updateUser(String userId, User user) throws NoDataFoundException {
		 Connection connection = null;      
	        PreparedStatement preparedStatement = null;
	        String updateStatement = "update user_table" +
	                " set userid=?, firstname=?, lastname=?, email=?, doj=?, dob=?, active=?" +
	                " where userid=?";
	        connection = dbUtils.getConnection();
	        try {
	            preparedStatement = connection.prepareStatement(updateStatement);
	            preparedStatement.setString(1, user.getUserId());
	            preparedStatement.setString(2, user.getFirstName());
	            preparedStatement.setString(3, user.getLastName());
	            preparedStatement.setString(4, user.getEmail());
	            preparedStatement.setDate(5, Date.valueOf(user.getDoj()));
	            preparedStatement.setDate(6, Date.valueOf(user.getDob()));
	            preparedStatement.setBoolean(7, user.isActive());

	            preparedStatement.setString(8, userId);

	            int result = preparedStatement.executeUpdate();

	            if(result > 0) {
	                return Optional.of(user);
	            }
	            else {
	                throw new NoDataFoundException("userid is not present");
	            }

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            dbUtils.closeConnection(connection);
	        }
	        return Optional.empty();
	}

	@Override
	public String deleteUser(String userId) throws NoDataFoundException {
		Optional<User> optional = this.getUserById(userId);
		if(optional.isPresent()){
			users.remove(optional.get());
			return "success";
		}
		else {
			throw new NoDataFoundException("Id Not Found:" + userId);
		}
	}

//	@Override
//	public Optional<Object> getAllUsers() {
//		 if(this.users.isEmpty() ) {
//	            return Optional.empty();
//	        }
//	        User[] users = new User[this.users.size()];
//	        this.users.toArray(users);
//	        return Optional.of(users);
//	}
	
	@Override
	public Optional<List<User>> getAllUsers() {
		 if(users.isEmpty() ) {
	            return Optional.empty();
	        }
	        
	        return Optional.of(new ArrayList<>(users));
	}

	@Override
	public Optional<User> getUserById(String userId) {
		
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	String query = "select * from"
			+ " user_table where userid=?";
	ResultSet resultSet = null;
	
	connection = dbUtils.getConnection();
	try {
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			User user = new User();
			
			user.setFirstName(resultSet.getString("firstname"));
			user.setLastName(resultSet.getString("lastname"));
			user.setEmail(resultSet.getString("email"));
			user.setDoj(resultSet.getDate("doj").toLocalDate());
			user.setDob(resultSet.getDate("dob").toLocalDate());
			user.setActive(resultSet.getBoolean("active"));
			return Optional.of(null);
			
		}
		else {
			return Optional.empty();
			
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
		
	}finally {
		dbUtils.closeConnection(connection);
	}return null;
	}
	
}
