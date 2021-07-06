package dao;

import metierEntite.User;

public interface UserDao {
	public User Add(User Et);
	public void Modify(User Et);
	public void Delete(int Id);
}
