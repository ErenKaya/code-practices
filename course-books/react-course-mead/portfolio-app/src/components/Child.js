import Parent from "./Parent";

export default class Child extends Parent {
   constructor() {
      super();
   }

   c = () => {
      super.c();
   };
}
