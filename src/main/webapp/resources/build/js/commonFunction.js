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