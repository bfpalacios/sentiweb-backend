package com.concretepage.dao;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Area;
import com.concretepage.entity.AreaRowMapper;
import com.concretepage.entity.Encuesta;
import com.concretepage.entity.EncuestaRowMapper;
 

@Transactional
@Repository
public class EncuestaDAO implements IEncuestaDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Encuesta> getEnecuestaPorRespuesta(long idEnc, long idPreg) {
		
		String sql = "SELECT id_rpta, id_enc, id_preg, desc_rpta FROM RESPUESTA WHERE id_enc = ? and id_preg=?";  
        RowMapper<Encuesta> rowMapper = new EncuestaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idEnc, idPreg);
	
	}

	@Override
	public String getEncuestaByFlag(long flagSenti, long idEnc, long idPreg) {
		String sql = "SELECT count(*) as contador from RESPUESTA where flag_senti=? and id_enc=? and id_preg=? ";
		RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
		String contador = jdbcTemplate.queryForObject(sql, rowMapper, flagSenti, idEnc, idPreg ); 
		//String contador = long.toString(contador1);
		
		return contador; 
		
	}

	@Override
	public List<Area> getEncuestaByPendiente(long idArea, long idEnc) {
		String sql = "SELECT count(*) as contador, a.nom_area from ENCUESTADOS e\n" + 
				"inner join COLABORADOR c ON c.id_colab=e.id_colab\n" + 
				"inner join AREA a ON a.id_area=c.id_area\n" + 
				"where id_enc=? and a.id_area=?" + 
				"";  
        RowMapper<Area> rowMapper = new AreaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idEnc, idArea);
	
	} 	 
	@Override
	public List<Encuesta> getEncuestaByRespondieron(long idArea, long idEnc) {
		String sql = "select count(*)/2 as contador, a.nom_area from RESPUESTA r  inner join AREA a ON r.id_area=a.id_area  "
				+"where id_enc=? and a.id_area=?" ;  
        RowMapper<Encuesta> rowMapper = new EncuestaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idEnc, idArea);
	
	} 

}
