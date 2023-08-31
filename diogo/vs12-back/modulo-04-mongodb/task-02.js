var nome = "Diogo"
const cpf = 12345678911

function sobreNome(){
    let sobrenome = "Bruno"
    console.log(sobrenome)
}

console.log(nome)
sobreNome()
console.log(cpf)



const tecnologia = "React"
const objetivoDaDisciplina = (tecnologia) => {
    return `Meu objetivo é aprender ${tecnologia}`
}
console.log(objetivoDaDisciplina(tecnologia))


let notas = []
notas.push(6.7)
notas.push(5.7)
notas.push(1.0)

console.log("A primeira nota do aluno é " + notas[0])
console.log("A segunda nota do aluno é " + notas[1])
console.log("A terceira nota do aluno é " + notas[2])


let media = (notas[0] + notas[1] + notas[2]) / notas.length
if(media >= 7){
    console.log("PASSOU")
}else { 
    console.log("NÃO PASSOU")
}
console.log("A media do aluno é "+media)