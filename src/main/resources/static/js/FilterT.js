document.getElementById("input-search").addEventListener("input", onInputChange)

function onInputChange() {
    let inputText= document.getElementById("input-search").value.toString().toLowerCase();
    
    let tableBody= document.getElementById("tableB");
    let tableRows= tableBody.getElementsByTagName("tr");
    

    for (let i = 0; i < tableRows.length; i++) {
        console.log(tableRows[i].cells[5].textContent);      

        let TextoConsulta= tableRows[i].cells[5].textContent.toString().toLowerCase();
        if (TextoConsulta.indexOf(inputText)=== -1) {
            tableRows[i].style.visibility ="collapse";
        }else {
            tableRows[i].style.visibility ="";
        }
    }
}