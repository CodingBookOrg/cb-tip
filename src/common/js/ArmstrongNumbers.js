function isArmstrong(number) {
    const digitCount = number.length;

    let sum = 0;
    for (let digitAsString of number) {
        let digit = parseInt(digitAsString, 10);
        sum += digit ** digitCount;
    }
    return sum == number;
}

function getNthArmstrongNumber(n) {
    let count = 0;
    for(let i = 1; i <= Number.MAX_VALUE; i++) {
        if(isArmstrong(pari)) {
            count++;

            if(count == n) {
                return i;
            }
        }
    }
}

console.log(isArmstrong('153'))
console.log(isArmstrong('120'))
console.log(isArmstrong(12))

