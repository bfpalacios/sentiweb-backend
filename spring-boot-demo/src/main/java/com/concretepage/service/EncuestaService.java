package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IEncuestaDAO;
import com.concretepage.entity.Area;
import com.concretepage.entity.Encuesta;
 

@Service
public class EncuestaService implements IEncuestaService{
	
	@Autowired
	private IEncuestaDAO encuestaDAO;
	@Override
	public List<Encuesta> getEnecuestaPorRespuesta(long idEnc, long idPreg) {
		return encuestaDAO.getEnecuestaPorRespuesta(idEnc, idPreg);
	}
	@Override
	public String getEncuestaByFlag(long flagSenti, long idEnc, long idPreg) {
		return encuestaDAO.getEncuestaByFlag( flagSenti,  idEnc, idPreg);
	}
	@Override
	public List<Area> getEncuestaByPendiente(long idArea, long idEnc) {
		// TODO Auto-generated method stub
		return encuestaDAO.getEncuestaByPendiente(idArea, idEnc);
	}
	@Override
	public List<Encuesta> getEncuestaByRespondieron(long idArea, long idEnc) {
		// TODO Auto-generated method stub
		return encuestaDAO.getEncuestaByRespondieron(idArea, idEnc);
	}

}
