jQuery(document).ready(() => {
	
	jQuery('#submitButton').click(() => {
		
		let inputs = jQuery('form').find('input');
		
		inputs.each((k, v) => {
			if (!validate(v)) {
				errorMessage();
			}
		});
		
	});
	
});

function validate(element) {
	
	let valid = element.validity.valid;
	console.log('Element valid: ' + valid);
	return valid;
	
}

function errorMessage() {
	console.log('Write error message');
	jQuery('#errorMessage').text('Please fill out all required fields.');
}