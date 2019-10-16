package clasesObjetosModelo;

public class PermisoFichaPublica {

	/**
	 * Clase para permisos de la Ficha Publica de la Mascota
	 */

	private String codigoQR;
	private Boolean esPublicoNombre;
	private Boolean esPublicoFechaNacimiento;
	private Boolean esPublicoEspecie;
	private Boolean esPublicoRaza;
	private Boolean esPublicoSexo;
	private Boolean esPublicoColor;
	private Boolean esPublicoSenias;
	private Boolean esPublicoImagen;
	private Boolean esPublicoDuenio;
	private Boolean esPublicoVeterinario;

	public PermisoFichaPublica() {
		this.setCodigoQR("");
		this.setEsPublicoNombre(true);
		this.setEsPublicoFechaNacimiento(false);
		this.setEsPublicoEspecie(false);
		this.setEsPublicoRaza(false);
		this.setEsPublicoSexo(false);
		this.setEsPublicoColor(false);
		this.setEsPublicoSenias(false);
		this.setEsPublicoImagen(false);
		this.setEsPublicoDuenio(false);
		this.setEsPublicoVeterinario(false);
	}

	public PermisoFichaPublica(
			String codigoQR,
			Boolean esPublicoNombre,
			Boolean esPublicoFechaNacimiento,
			Boolean esPublicoEspecie,
			Boolean esPublicoRaza,
			Boolean esPublicoSexo,
			Boolean esPublicoColor,
			Boolean esPublicoSenias,
			Boolean esPublicoImagen,
			Boolean esPublicoDuenio,
			Boolean esPublicoVeterinario) {
		this.setCodigoQR(codigoQR);
		this.setEsPublicoNombre(esPublicoNombre);
		this.setEsPublicoFechaNacimiento(esPublicoFechaNacimiento);
		this.setEsPublicoEspecie(esPublicoEspecie);
		this.setEsPublicoRaza(esPublicoRaza);
		this.setEsPublicoSexo(esPublicoSexo);
		this.setEsPublicoColor(esPublicoColor);
		this.setEsPublicoSenias(esPublicoSenias);
		this.setEsPublicoImagen(esPublicoImagen);
		this.setEsPublicoDuenio(esPublicoDuenio);
		this.setEsPublicoVeterinario(esPublicoVeterinario);
	}

	public String getCodigoQR() {
		return codigoQR;
	}

	public void setCodigoQR(String codigoQR) {
		this.codigoQR = codigoQR;
	}

	public Boolean getEsPublicoNombre() {
		return esPublicoNombre;
	}

	public void setEsPublicoNombre(Boolean esPublicoNombre) {
		this.esPublicoNombre = esPublicoNombre;
	}

	public Boolean getEsPublicoFechaNacimiento() {
		return esPublicoFechaNacimiento;
	}

	public void setEsPublicoFechaNacimiento(Boolean esPublicoFechaNacimiento) {
		this.esPublicoFechaNacimiento = esPublicoFechaNacimiento;
	}

	public Boolean getEsPublicoEspecie() {
		return esPublicoEspecie;
	}

	public void setEsPublicoEspecie(Boolean esPublicoEspecie) {
		this.esPublicoEspecie = esPublicoEspecie;
	}

	public Boolean getEsPublicoRaza() {
		return esPublicoRaza;
	}

	public void setEsPublicoRaza(Boolean esPublicoRaza) {
		this.esPublicoRaza = esPublicoRaza;
	}

	public Boolean getEsPublicoSexo() {
		return esPublicoSexo;
	}

	public void setEsPublicoSexo(Boolean esPublicoSexo) {
		this.esPublicoSexo = esPublicoSexo;
	}

	public Boolean getEsPublicoColor() {
		return esPublicoColor;
	}

	public void setEsPublicoColor(Boolean esPublicoColor) {
		this.esPublicoColor = esPublicoColor;
	}

	public Boolean getEsPublicoSenias() {
		return esPublicoSenias;
	}

	public void setEsPublicoSenias(Boolean esPublicoSenias) {
		this.esPublicoSenias = esPublicoSenias;
	}

	public Boolean getEsPublicoImagen() {
		return esPublicoImagen;
	}

	public void setEsPublicoImagen(Boolean esPublicoImagen) {
		this.esPublicoImagen = esPublicoImagen;
	}

	public Boolean getEsPublicoDuenio() {
		return esPublicoDuenio;
	}

	public void setEsPublicoDuenio(Boolean esPublicoDuenio) {
		this.esPublicoDuenio = esPublicoDuenio;
	}

	public Boolean getEsPublicoVeterinario() {
		return esPublicoVeterinario;
	}

	public void setEsPublicoVeterinario(Boolean esPublicoVeterinario) {
		this.esPublicoVeterinario = esPublicoVeterinario;
	}

}
