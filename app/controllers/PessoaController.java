package controllers;

import models.Pessoa;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import request.PessoaRequest;
import entitys.response.AbstractResponse;

public class PessoaController extends Controller {

    public static Result index() {
   
    	return ok(views.html.template.render());
    }
    
    
    public static Result findAllPessoas(){
    	return ok(Json.toJson(Pessoa.findAllPessoa()));
    	
    }
    
    public static Result findPessoasByCPF(Long cpf){
		
    	if(Pessoa.findByCPF(cpf) == null){
			return ok(Json.toJson("0"));
		}
		
    	return ok(Json.toJson(Pessoa.findByCPF(cpf)));
    	
    }
    
    
	public static Result cadastrarPessoa(){

		Form<PessoaRequest> form = Form.form(PessoaRequest.class);
		form = form.bindFromRequest();
		PessoaRequest request = form.get();

		AbstractResponse response = null;

		Pessoa pessoa = new Pessoa();
			
			

			pessoa.setCpf(request.getCpf());
			pessoa.setNome(request.getNome());
			pessoa.setDia(request.getDia());
			pessoa.setMes(request.getMes());
			pessoa.setAno(request.getAno());
			pessoa.setPeso(request.getPeso());
			pessoa.setUf(request.getUf());
			


			//verificação para saber se o setor já foi cadastrado antes na propriedade e safra
			if(Pessoa.findByCPF(pessoa.getCpf()) == null){
				
				if(Pessoa.save(pessoa)){
					//cadastra o setor no banco e envia a mensagem de sucesso
						response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(), 
								 "Pessoa adicionada com Sucesso!");
				}else{
						response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDescricao(), AbstractResponse.TypeEnum.DANGER.getDescricao(), 
								 "Erro ao adicionar Pessoa!");		
					}
			}else{
				response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDescricao(), AbstractResponse.TypeEnum.WARNING.getDescricao(), 
						 " CPF da pessoa já existe!");
			}
		

		return ok(Json.toJson(response));
	}
	
	
	public static Result editarPessoa(){

		Form<PessoaRequest> form = Form.form(PessoaRequest.class);
		form = form.bindFromRequest();
		PessoaRequest request = form.get();

		AbstractResponse response = null;

		Pessoa pessoa = Pessoa.findByCPF(request.getCpf());
		
		if(pessoa != null) {
			pessoa.setNome(request.getNome());
			pessoa.setDia(request.getDia());
			pessoa.setMes(request.getMes());
			pessoa.setAno(request.getAno());
			pessoa.setPeso(request.getPeso());
			pessoa.setUf(request.getUf());
		
				try {
					Pessoa.update(pessoa);

					response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(),
							 "Pessoa editada com sucesso!");
				} catch (Exception e) {

					response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDescricao(), AbstractResponse.TypeEnum.DANGER.getDescricao(),
							 "Erro interno do servidor. Tente novamente");
				}
			
			
			return ok(Json.toJson(response));
		}
		System.out.println("chegou aqui");
		
		return ok("nada encontrado");
	}
	
	public static Result deletarPessoa(Long cpf) {

		AbstractResponse response = null;

		Pessoa pessoa = Pessoa.findByCPF(cpf);
		if(pessoa != null) {
			try {
				Pessoa.delete(cpf);

				response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(),
						 "Pessoa excluída com sucesso!");
			} catch(Exception e) {
				response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDescricao(), AbstractResponse.TypeEnum.DANGER.getDescricao(),
						 "Erro interno do servidor. Tente novamente");
			}
		}
		return ok(Json.toJson(response));
	}
}
