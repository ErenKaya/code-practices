/**
 * Object Destructuring...
 */

// const book = {
//     title: 'Ego is the Enemy',
//     author: 'Ryan Holiday',
//     publisher: {
//         // name: 'Penguin'
//     }
// };

// const { name: publisherName = 'Self-Published' } = book.publisher;
// console.log(publisherName);


/**
 * Array Destructuring...
 */
// const address = [
//     {
//         fAddress: '1299 S Juniper',
//         city: 'Philedelphia',
//         state: 'Pennysylvania',
//         zipCode: '19147'
//     },
//     {
//         fAddress: 'GümüşPala ',
//         city: 'İstanbul',
//         state: 'Turkey',
//         zipCode: '34566'
//     }
// ]

// const address = [
//     '1299 S Juniper',
//     'Philedelphia',
//     'Pennysylvania',
//     '19147'
// ];

const item = ['Coffee (Hot)', '2TL', '2.5TL', '3TL'];
const [coffeeName, smallPrice, mediumPrice, tallPrice] = item;

// const [, city, state] = address;
console.log(`${coffeeName}, small price is ${smallPrice}, medium price is ${mediumPrice}, tall price is ${tallPrice}`)
// console.log(`You are in ${city} ${state}`);