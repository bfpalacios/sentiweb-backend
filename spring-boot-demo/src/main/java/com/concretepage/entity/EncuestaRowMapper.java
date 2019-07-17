package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
 

public class EncuestaRowMapper implements RowMapper<Encuesta> {

	@Override
	public Encuesta mapRow(ResultSet row, int rowNum) throws SQLException {
		Encuesta encuesta = new Encuesta();
		encuesta.setIdRpta(row.getInt("id_rpta"));
		encuesta.setIdEnc(row.getInt("id_enc"));
		encuesta.setIdPreg(row.getInt("id_preg"));
		encuesta.setDescRpta(row.getString("desc_rpta")); 
		encuesta.setCantidad(row.getInt("contador")); 
		return encuesta;
	}

}
