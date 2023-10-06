/**
 * 
 */
$(function(){
	// User2
	$('#btnUser2s').click(function(){
		
		$.ajax({
			url: '/Ch10/user2',
			type: 'GET',						
			dataType: 'json',
			success: function(data){
				console.log(data);							
			},
	    	error: function(xhr, status, error) {
	        console.error(xhr.responseText);
	    }
			
		});
		
	});
	
	$('#btnUser2').click(function(){
		$.ajax({
			url: '/Ch10/user2/s102',
			type: 'GET',						
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser2Register').click(function(){
		
		const jsonData = {
			id: 's102',
			name: '김콜라',
			hp: '010-1111-1002',
			age: 30 
		};
		
		$.ajax({
			url: '/Ch10/user2',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser2Modify').click(function(){
		const jsonData = {
			id: 's102',
			name: '김환타',
			hp: '010-000-1005',
			age: 25
		};
		
		$.ajax({
			url: '/Ch10/user2',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser2Delete').click(function(){
		$.ajax({
			url: '/Ch10/user2/s102',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
});