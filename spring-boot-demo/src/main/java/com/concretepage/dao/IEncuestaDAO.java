package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Encuesta;
 
 

public interface IEncuestaDAO {
	
	 List<Encuesta> getEnecuestaPorRespuesta(long idEnc, long idPreg);
	 String getEncuestaByFlag(long flagSenti, long idEnc,  long idPreg);
	 List<Encuesta> getEncuestaByPendiente(long idArea, long idEnc);
	 List<Encuesta> getEncuestaByRespondieron(long idArea, long idEnc);
}
