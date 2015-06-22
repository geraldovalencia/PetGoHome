package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.banner.Banner;
import br.com.petGoHome.banner.HistoricoBanner;

public class HistoricoBannerDao extends AbstractDao<HistoricoBanner> {

	public HistoricoBannerDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<HistoricoBanner> entityClass() {
		// TODO Auto-generated method stub
		return HistoricoBanner.class;
	}
	

public List<HistoricoBanner> buscarHistoricoBannerPorBanner(long idHistoricoBanner) {

    Query query = manager.createQuery("SELECT e FROM HistoricoBanner e WHERE e.bannerId = :idHistoricoBanner");

    query.setParameter("idHistoricoBanner",idHistoricoBanner);
    return query.getResultList();
}

}
