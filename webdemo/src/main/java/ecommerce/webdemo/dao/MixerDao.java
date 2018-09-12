package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Mixer;

public interface MixerDao {
	public boolean addMixer(Mixer mixer);
	public boolean deleteMixer(Mixer mixer);
	public boolean updateMixer(Mixer mixer);
}
