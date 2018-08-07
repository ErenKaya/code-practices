//argument object - no longer bound with arrow functions.
const add = (a, b) => {
    //console.log(arguments);
    return a + b;
}
console.log(add(100, 55, 1));

const user = {
    name: 'Eren',
    cities: ['Bursa', 'Edirne', 'Istanbul'],
    printPlacesLived: function () {
        return this.cities.map((city) => this.name + ' has lived in ' + city)
    }
};
console.log(user.printPlacesLived())

//Challange Area
const multiplier = {
    numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0],
    multiplyBy: 0,
    multiply() {
        return this.numbers.map((number) => this.multiplyBy * number);
    }
}
multiplier.multiplyBy = 5;
console.log(multiplier.multiply());