/**
 * 
 */

var currentUrl = "";

$(document).ready(() => {
	
	$(".delete").on('click', (ev) => {
		
		var deleteId = ev.target.id;
		
		$.ajax({
			url:currentUrl + deleteId,
			method: 'DELETE',
			success:() => {
				location.reload();
			}
		});		
	})
	
})