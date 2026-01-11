function plusPetitQue(x) {
    return function(y) {
        return y < x;
    };
}

let plusPetitQue10 = plusPetitQue(10);
console.log(plusPetitQue10(12)); //false
console.log(plusPetitQue10(9)); //true