package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.MixerDao;
import ecommerce.webdemo.model.Mixer;




@Component
@Transactional
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
