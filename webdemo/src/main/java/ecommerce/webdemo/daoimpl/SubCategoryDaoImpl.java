package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.model.Category;
import ecommerce.webdemo.model.SubCategory;

@Component
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao{

	@Autowired
	private SessionFactory factory;

	@Override
	public SubCategory getSubCategory(int sid) {
		try {
			return factory.getCurrentSession().get(SubCategory.class, sid);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<SubCategory> getSubCategoryById(int cid) 
	{
		try
		{
		Query<SubCategory> query=factory.getCurrentSession().createQuery("from SubCategory where Category_cid=:cid",SubCategory.class);
		query.setParameter("cid", cid);
		return query.getResultList();
		}
		catch(Exception e)
		{
		return null;
	}
	}
	@Override
	public List<SubCategory> getAllSubCategoryList() {

		try {
			return factory.getCurrentSession().createCriteria(SubCategory.class).list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getElectronics() {
		try {
			Query<SubCategory> query = factory.getCurrentSession()
					.createQuery("from SubCategory where category_cid=1", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	/*@Override
	public List<SubCategory> getMens() {
		try {
			Query<SubCategory> query =factory.getCurrentSession()
					.createQuery("from SubCategory where category_cid=3", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getWomens() {
		try {
			Query<SubCategory> query =factory.getCurrentSession()
					.createQuery("from SubCategory where category_cid=2", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
*/
	

}
