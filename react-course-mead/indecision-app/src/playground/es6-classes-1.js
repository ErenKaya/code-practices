class Person {
    constructor(name = 'Anonymous', age = 0) {
        this.name = name;
        this.age = age;
    }
    getGreeting() {
        // return 'hi! ' + this.name;
        return `Hi I am ${this.name}! `;
    }

    getDescription() {
        return `${this.name} is ${this.age} years old!`;
    }

}

class Student extends Person {
    constructor(name, age, major) {
        super(name, age);
        this.major = major;
    }

    hasMajor() {
        return !!this.major;
    }

    getDescription() {
        let desc = super.getDescription();
        if (this.hasMajor()) {
            desc += ` Their major is ${this.major}.`;
        }
        return desc;
    }
}

class Traveller extends Person{
    constructor(name,age,location){
        super(name,age);
        this.location =location;
    }

    hasLocation(){
        return !!this.location;
    }

    getGreeting(){
        let greeting = super.getGreeting();
        if(this.hasLocation()){
            console.log('test');
            greeting += ` I'm visiting from ${this.location}`;
        }
        return greeting;
    }
}
const me = new Person('Eren', 26);
console.log(me.getGreeting());

const other = new Person();
console.log(other.getGreeting());

const student = new Student("Jr Eren", 15, 'CTIS');
console.log(student.getDescription());

const student2 = new Student();
console.log(student2.getDescription());

const traveller1 = new Traveller('Ibrahim',26,'Tokat');
console.log(traveller1.getGreeting());

const traveller2 = new Traveller();
console.log(traveller2.getGreeting());