package com.nbeverton.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.nbeverton.dao.AdressDAO;
import com.nbeverton.entity.Adress;
import com.nbeverton.util.ErroSystem;

//@ManagedBean
//@SessionScoped
public class AdressBean {
	
	private Adress adress = new Adress();
	private List<Adress> adressList = new ArrayList<>();
	private AdressDAO adressDao = new AdressDAO();
	
	public void addAdress() throws ErroSystem{
		adressList.add(adress);
		adressDao.saveAdress(adress);
		adress = new Adress();
	}
	
	public void searchAdress() throws ErroSystem{
		adressList = adressDao.searchAdress();
	}
	
	public void editAdress(Adress a) throws ErroSystem{
		adress = a;
	}
	
	public void deleteAdress(Adress a) throws ErroSystem {
		adressDao.deleteAdress(a.getId());
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Adress> getAdressList() {
		return adressList;
	}

	public void setAdressList(List<Adress> adressList) {
		this.adressList = adressList;
	}

	public AdressDAO getAdressDao() {
		return adressDao;
	}

	public void setAdressDao(AdressDAO adressDao) {
		this.adressDao = adressDao;
	}

}
