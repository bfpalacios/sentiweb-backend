package com.concretepage.entity;
 
 
public class Encuesta {

	private long idRpta;
	private long idPreg;
    private long idEnc;
    private long cantidad;
    private String descRpta;
     

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getIdRpta() {
		return idRpta;
	}

	public void setIdRpta(long idRpta) {
		this.idRpta = idRpta;
	}

	public long getIdPreg() {
		return idPreg;
	}

	public void setIdPreg(long idPreg) {
		this.idPreg = idPreg;
	}

	public long getIdEnc() {
		return idEnc;
	}

	public void setIdEnc(long idEnc) {
		this.idEnc = idEnc;
	}

	public String getDescRpta() {
		return descRpta;
	}

	public void setDescRpta(String descRpta) {
		this.descRpta = descRpta;
	}

	 
      
}
