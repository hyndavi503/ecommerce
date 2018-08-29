package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.AccountDao;
import ecommerce.webdemo.model.Account;

@Component
@Transactional
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().save(account);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(account);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
		return false;
		}
	}
	

}
