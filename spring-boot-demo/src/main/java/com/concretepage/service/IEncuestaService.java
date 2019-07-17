package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Area;
import com.concretepage.entity.Encuesta;
 

public interface IEncuestaService {
	
	List<Encuesta> getEnecuestaPorRespuesta(long idEnc, long idPreg);
	List<Area> getEncuestaByPendiente(long idArea, long idEnc);
	String getEncuestaByFlag(long flagSenti, long idEnc, long idPreg);


	 List<Encuesta> getEncuestaByRespondieron(long idArea, long idEnc);
}
