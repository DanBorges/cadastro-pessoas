package controllers;


import models.Pessoa;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import request.PessoaRequest;
import entitys.response.AbstractResponse;
import views.html.*;



public class PessoaController extends Controller {

    public static Result index() {
    	return ok(template.render());
    }
    
    //método para retornar todas as tuplas da tabela Pessoas
    public static Result findAllPessoas(){
    	return ok(Json.toJson(Pessoa.findAllPessoa()));
    }
    
	public static Result cadastrarPessoa(){
		Form<PessoaRequest> form = Form.form(PessoaRequest.class);
		form = form.bindFromRequest();
		PessoaRequest request = form.get();
		AbstractResponse response = null;
		Pessoa pessoa = new Pessoa();
		
		//Setando atributos de pessoas com os valores passados pelo front-end
		pessoa.setCpf(request.getCpf());
		pessoa.setNome(request.getNome());
		pessoa.setDia(request.getDia());
		pessoa.setMes(request.getMes());
		pessoa.setAno(request.getAno());
		pessoa.setPeso(request.getPeso());
		pessoa.setUf(request.getUf());

		//Condição para retornar mensagem para Toast pela classe AbstractResponse
		if(Pessoa.validarMesmoCpf(pessoa) == true){
			response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(), "Pessoa adicionada com Sucesso!");
		}
		
		else{
			response = new AbstractResponse(AbstractResponse.IconEnum.WARNING_SIGN.getDescricao(), AbstractResponse.TypeEnum.WARNING.getDescricao(), " CPF da pessoa já existe!");		
		}
		
		//Chamar função para cadastrar pessoa
		Pessoa.cadastrarPessoaModel(pessoa);
		
		return ok(Json.toJson(response));
	}
	
	
	public static Result editarPessoa(){

		Form<PessoaRequest> form = Form.form(PessoaRequest.class);
		form = form.bindFromRequest();
		PessoaRequest request = form.get();
		AbstractResponse response = null;
		Pessoa pessoa = Pessoa.findByCPF(request.getCpf());
		
		if(Pessoa.validarMesmoCpf(pessoa)== false) {
			pessoa.setNome(request.getNome());
			pessoa.setDia(request.getDia());
			pessoa.setMes(request.getMes());
			pessoa.setAno(request.getAno());
			pessoa.setPeso(request.getPeso());
			pessoa.setUf(request.getUf());
			Pessoa.editarPessoaModel(pessoa);
			response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(),"Pessoa editada com sucesso!");
		}
		else{
			response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDescricao(), AbstractResponse.TypeEnum.DANGER.getDescricao(),"Erro interno do servidor. Tente novamente");
		}
		return ok(Json.toJson(response));
	}
	
	public static Result deletarPessoa(Long cpf) {
		AbstractResponse response = null;
		Pessoa pessoa = Pessoa.findByCPF(cpf);
		if(pessoa != null) {
			try {
				Pessoa.deletarModel(cpf);
				response = new AbstractResponse(AbstractResponse.IconEnum.THUMBS_UP.getDescricao(), AbstractResponse.TypeEnum.SUCCESS.getDescricao(),"Pessoa excluída com sucesso!");
			} 
			catch(Exception e) {
				response = new AbstractResponse(AbstractResponse.IconEnum.REMOVE.getDescricao(), AbstractResponse.TypeEnum.DANGER.getDescricao(),"Erro interno do servidor. Tente novamente");
			}
		}
		return ok(Json.toJson(response));
	}
	
}
