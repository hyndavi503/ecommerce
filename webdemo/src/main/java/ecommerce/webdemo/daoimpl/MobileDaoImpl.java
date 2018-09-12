package ecommerce.webdemo.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.MobileDao;
import ecommerce.webdemo.model.Mobile;

@Transactional
@Component
public class MobileDaoImpl implements MobileDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().save(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().delete(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	

	@Override
	public boolean updateMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().update(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
