/**
 * 
 */

$(document).ready(() => {
	
	var buildContatoEntry = (parent, propName) => {
		
		var input = $("<input name='contato." + propName + "' class='form-control'>");
		var deleteButton = $("<button type='button'>x</button>");
		
		deleteButton.on('click', (ev1) => {
			$(ev1.target.parentElement).remove();
		})
		
		var container = $("<div class='row form-group'>");
		container.append(input);
		container.append(deleteButton);
		
		parent.append(container);
	}
	
	
	$(".contato-email button").on('click', (ev) => {
		
		buildContatoEntry($(ev.target.parentElement), 'emails')
		
	})
	
	$(".contato-endereco button").on('click', (ev) => {
		
		buildContatoEntry($(ev.target.parentElement), 'enderecos')
		
	})
	
	$(".contato-telefone button").on('click', (ev) => {
		
		buildContatoEntry($(ev.target.parentElement), 'telefones')
		
	})
})