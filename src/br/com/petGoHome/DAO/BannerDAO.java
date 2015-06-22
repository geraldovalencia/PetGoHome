package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.banner.Banner;

public class BannerDAO extends AbstractDao<Banner>{

	public BannerDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Banner> entityClass() {
		// TODO Auto-generated method stub
		return Banner.class;
	}

	public Banner buscarBanner(long id){
		return manager.find(Banner.class, id);
	}
	
}
