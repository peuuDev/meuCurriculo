const btnTopo = document.querySelector("#btnTopo");

// Aparência do botao
window.addEventListener("scroll", () =>{

    if(window.scrollY > 300){
        btnTopo.classList.add("visivel");
    } else{
        btnTopo.classList.remove("visivel");
    }
})

//Função onClick do botão
btnTopo.addEventListener("click", () =>{

    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });

});