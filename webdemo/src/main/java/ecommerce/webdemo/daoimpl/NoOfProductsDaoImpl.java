package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.NoOfProductsDao;
import ecommerce.webdemo.model.NoOfProducts;



@Component
@Transactional
public class NoOfProductsDaoImpl  implements NoOfProductsDao {

	
	@Autowired
	private SessionFactory factory;
	@Override
	public boolean addNoOfProducts(NoOfProducts noOfProducts) {
		try {
		factory.getCurrentSession().save(noOfProducts);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	}


