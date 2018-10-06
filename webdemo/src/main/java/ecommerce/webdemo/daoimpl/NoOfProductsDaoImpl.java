package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	@Override
	public List<NoOfProducts> getNoOfProducts(int pid) {
		try {
			Query<NoOfProducts> query= factory.getCurrentSession()
					.createQuery("from NoOfProducts where products_pid=:pid and sold=false");
			
					query.setParameter("pid", pid);
					return query.getResultList();
		} catch (Exception e) {

			return null;
		}
	}
	@Override
	public NoOfProducts getNoOfProductsByNoOfproductsId(int itemNo) {
		try {
			return (NoOfProducts) factory.getCurrentSession()
					.createQuery("from NoOfProducts where itemNo=:id").setParameter("id", itemNo)
					.getSingleResult();
		} catch (HibernateException e) {
			
			return null;
		}
	}
	}


