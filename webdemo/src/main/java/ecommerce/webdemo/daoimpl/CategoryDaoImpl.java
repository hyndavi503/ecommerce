package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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


}
