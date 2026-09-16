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

//Funçoes btnSobre
const btnSobre = document.querySelector("#btnSobre");

let estado = 1;

btnSobre.addEventListener("mouseenter", () => {

    if (estado === 1) {
        estado = 2;
        btnSobre.classList.add("estado2");
    }

});

btnSobre.addEventListener("mouseleave", () => {
    if(estado === 2){
        estado = 1;
        btnSobre.classList.remove("estado2");
    }
})

btnSobre.addEventListener("click", () => {

    if (estado === 2) {

        estado = 3;

        btnSobre.classList.remove("estado2");
        btnSobre.classList.add("estado3");

    } else if (estado === 3) {

        estado = 1;

        btnSobre.classList.remove("estado3");

    }

});