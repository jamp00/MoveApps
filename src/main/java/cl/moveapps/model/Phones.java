package cl.moveapps.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Phones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPhone;
	
	private int number;
	private int cityCode;
	private int contryCode;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
	private Usuarios usuario;

    public Phones() {
    	
    }

	public Phones(int number, int cityCode, int contryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
	}

	public int getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public int getCountriCode() {
		return contryCode;
	}
	public void setCountriCode(int contriCode) {
		this.contryCode = contriCode;
	}


	@Override
	public String toString() {
		return "Phones [idPhone=" + idPhone + ", number=" + number + ", cityCode=" + cityCode + ", countriCode="
				+ contryCode + "]";
	}


}
