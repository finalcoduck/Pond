/**
 * 공통js파일 작성폴더
 * 
 */


//deltaObject를 HTML코드로 변경
		function quillGetHTML(inputDelta) {
			//var delta = JSON.parse(inputDelta);
		    var tempCont = document.createElement("div");
		    (new Quill(tempCont)).setContents(inputDelta.ops);
		    return tempCont.getElementsByClassName("ql-editor")[0].innerHTML;
		}
		function bytesToSize(bytes) {
			   var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
			   if (bytes == 0) return '0 Byte';
			   var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
			   return Math.round(bytes / Math.pow(1024, i), 2) + ' ' + sizes[i];
			};