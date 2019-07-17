package com.concretepage.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.entity.Encuesta;
import com.concretepage.service.IEncuestaService;   
 
@Controller
@RequestMapping("/api/v1")
public class EncuestaController {
	
	@Autowired
	private IEncuestaService  encuestaService; 
 
	
	
	//reporte pastel 
	@GetMapping("/encuesta/{flagSenti}/{idEnc}")
    public ResponseEntity<String> getEncuestaByFlag(@PathVariable(value = "flagSenti") Long flagSenti,
    		@PathVariable(value = "idEnc") Long idEnc, @PathVariable(value = "idPreg") Long idPreg
    ) {
    	String contador = encuestaService.getEncuestaByFlag(flagSenti, idEnc, idPreg);
    	return new ResponseEntity<String>(contador, HttpStatus.OK);
    }
	
	
    @GetMapping("/encuesta/{idEnc}/{idPreg}")
    public ResponseEntity<List<Encuesta>> getEncuestaByRespuesta(@PathVariable(value = "idEnc") Long idEnc,
    		@PathVariable(value = "idPreg") Long idPreg
    ){
    	List<Encuesta> list = encuestaService.getEnecuestaPorRespuesta(idEnc, idPreg);
    	return new ResponseEntity<List<Encuesta>>(list, HttpStatus.OK);
    }
    
    
    /*2.1 Servicio rest se envia parametro id_Area y id_encuesta y debe listar el status de las encuestas:

Sirve para:
Listar NombreArea, Cant Encuestas Respondidas, Cantidad Encuestas Pendientes Responder y Cantidad Total de Encuestados

--TOTAL A ENCUESTAR POR AREA POR ID_ENC
select count(*), a.nom_area from ENCUESTADOS e
inner join COLABORADOR c ON c.id_colab=e.id_colab
inner join AREA a ON a.id_area=c.id_area
where id_enc=2
    */
    @GetMapping("/encuesta/pendiente/{idArea}/{idEnc}")
    public ResponseEntity<List<Encuesta>> getEncuestaByPendiente(@PathVariable(value = "idArea") Long idArea,
    		@PathVariable(value = "idEnc") Long idEnc
    ){
    	List<Encuesta> list = encuestaService.getEncuestaByPendiente(idArea, idEnc);
    	return new ResponseEntity<List<Encuesta>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/encuesta/respuondieron/{idArea}/{idEnc}")
    public ResponseEntity<List<Encuesta>> getEncuestaByPendiente(@PathVariable(value = "idArea") Long idArea,
    		@PathVariable(value = "idEnc") Long idEnc
    ){
    	List<Encuesta> list = encuestaService.getEncuestaByRespondieron(idArea, idEnc);
    	return new ResponseEntity<List<Encuesta>>(list, HttpStatus.OK);
    }

}
