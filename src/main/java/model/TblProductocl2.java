package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_PRODUCTOCL2 database table.
 * 
 */
@Entity
@Table(name="TBL_PRODUCTOCL2")
@NamedQuery(name="TblProductocl2.findAll", query="SELECT t FROM TblProductocl2 t")
public class TblProductocl2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPRODUCTOCL2")
	private int idproductocl2;

	@Column(name="DESCRIPCL2")
	private String descripcl2;

	@Column(name="ESTADOCL2")
	private String estadocl2;

	@Column(name="NOMBRECL2")
	private String nombrecl2;

	@Column(name="PRECIOCOMPCL2")
	private double preciocompcl2;

	@Column(name="PRECIOVENTACL2")
	private double precioventacl2;

	public TblProductocl2() {
	}

	public int getIdproductocl2() {
		return this.idproductocl2;
	}

	public void setIdproductocl2(int idproductocl2) {
		this.idproductocl2 = idproductocl2;
	}

	public String getDescripcl2() {
		return this.descripcl2;
	}

	public void setDescripcl2(String descripcl2) {
		this.descripcl2 = descripcl2;
	}

	public String getEstadocl2() {
		return this.estadocl2;
	}

	public void setEstadocl2(String estadocl2) {
		this.estadocl2 = estadocl2;
	}

	public String getNombrecl2() {
		return this.nombrecl2;
	}

	public void setNombrecl2(String nombrecl2) {
		this.nombrecl2 = nombrecl2;
	}

	public double getPreciocompcl2() {
		return this.preciocompcl2;
	}

	public void setPreciocompcl2(double preciocompcl2) {
		this.preciocompcl2 = preciocompcl2;
	}

	public double getPrecioventacl2() {
		return this.precioventacl2;
	}

	public void setPrecioventacl2(double precioventacl2) {
		this.precioventacl2 = precioventacl2;
	}

}