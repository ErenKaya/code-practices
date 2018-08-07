const square = function(x){
    return x*x;
}

console.log(square(5));
var squareArrow = (x)=>{
    return x*x;
};

var squareArrowFunctionShortHand= (x)=>x*x;
console.log( squareArrow(8));

console.log(squareArrowFunctionShortHand(7));

const fullName = 'Eren Kaya'

const splitNameFromFullName = (x) =>{
return x.split(" ")[0];
};

const splitNameFromFullNameSH = (name) => name.split(" ")[0];

console.log(splitNameFromFullName(fullName));


console.log(splitNameFromFullNameSH(fullName));