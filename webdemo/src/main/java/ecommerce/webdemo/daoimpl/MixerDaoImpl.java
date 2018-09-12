package ecommerce.webdemo.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecommerce.webdemo.dao.MixerDao;
import ecommerce.webdemo.model.Mixer;

public class MixerDaoImpl implements MixerDao{

	
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addMixer(Mixer mixer) {
		try {
			sessionFactory.getCurrentSession().save(mixer);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteMixer(Mixer mixer) {
		try {
			sessionFactory.getCurrentSession().delete(mixer);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateMixer(Mixer mixer) {
		try {
			sessionFactory.getCurrentSession().update(mixer);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
