package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.model.SubCategory;

@Component
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao{

	@Autowired
	private SessionFactory factory;
	@Override
	public SubCategory getSubCategory(int sid) {
		try
		{
			return factory.getCurrentSession().get(SubCategory.class, sid);
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
