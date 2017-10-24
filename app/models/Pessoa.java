package models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="pessoa")
public class Pessoa extends Model {
	
	private static final long serialVersionUID = -1651108399238931078L;
	
	public static Finder<Long,Pessoa> find = new Finder<Long,Pessoa>(Long.class, Pessoa.class);

	public static Pessoa findByCPF(Long cpf) {
		
		return find.where().eq("cpf", cpf).findUnique();
	}
	
	
	
	public static List<Pessoa> findAllPessoa(){
		return find.all();
	}
	
	
	public static boolean save(Pessoa pessoa) {
		
		try {
			pessoa.save();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean update(Pessoa pessoa) {
		
		try {
			pessoa.update();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public static boolean delete(Long cpf) {
		
		try {
			Pessoa pessoa = Pessoa.findByCPF(cpf);
			pessoa.delete();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	


	
	@Id
	private Long cpf;
	
	private String nome;
	
	private int dia;
	
	private int mes;
	
	private int ano;
	
	private BigDecimal peso;
	
	private String uf;

	public Long getCpf() {
		return cpf;
	}



	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getDia() {
		return dia;
	}



	public void setDia(int dia) {
		this.dia = dia;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public BigDecimal getPeso() {
		return peso;
	}



	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}




	

	

}
