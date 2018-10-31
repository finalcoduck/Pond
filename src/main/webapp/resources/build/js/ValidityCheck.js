/**
 * 
 */

/*// 파일 확장자 유효성 체크
	 $('@@@@@').on('change',function(event){
		const image = event.target.files;
		console.log(image[0].type);
		$.each(image, function(i,elt){
			if(!validImageType(elt.type)){
				$('input[name=file]').val('');
				alert('첨부 불가능한 파일 입니다.');
				return;
			} 
		});
	}); 
	
	 function validImageType(image){
		const result = (['image/png','image/jpeg','image/jpg'].indexOf(image) > -1);
		return result;
	}*/ 