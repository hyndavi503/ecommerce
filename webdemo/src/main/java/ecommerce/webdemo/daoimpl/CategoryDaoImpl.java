package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.model.Category;

@Component
@Transactional
public class CategoryDaoImpl implements CategoryDao
{
@Autowired
private SessionFactory factory;

@Override
public boolean addCategory(Category category) {
	try
	{
		factory.getCurrentSession().save(category);
		return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

@Override
public List<Category> getCategoryDetails() {
	try {
		Query<Category> query=factory.getCurrentSession().createQuery("from Category", Category.class);
		return query.getResultList();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
	
}

@Override
public Category getCategoryId(int cid) {
	try {
		return factory.getCurrentSession().get(Category.class, cid);
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
}


}
